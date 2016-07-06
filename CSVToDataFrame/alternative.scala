import java.sql.Timestamp
import sqlContext.implicits._

case class Register(Estacao:String,Data:Timestamp,Tipo:String,Valor:Short,Latitude:Float,Longitude:Float);

val station = sc.textFile("wasb://datasets@storagegrupocluster.blob.core.windows.net/ghcnd-stations.txt").
map(l=>(l.substring(0,11),
    (l.substring(12,20).trim.toFloat,
    l.substring(21,30).trim.toFloat
       )));
station.take(10).foreach(println);

val csvs = sc.textFile("wasb://datasets@storagegrupocluster.blob.core.windows.net/*.csv").map(
l=>(l.split(",")(0),(
new Timestamp(l.split(",")(1).substring(0,4).toInt-1900,
              l.split(",")(1).substring(4,6).toInt-1,
              l.split(",")(1).substring(6,8).toInt,0,0,0,0),
              l.split(",")(2),l.split(",")(3).toShort)));

val staxcsvs = csvs.join(station).map(l=>Register(l._1,l._2._1._1,l._2._1._2,l._2._1._3,l._2._2._1,l._2._2._2)).toDF;

staxcsvs.take(10).foreach(println);
staxcsvs.write.save("wasb:///dados.parquet");

staxcsvs.registerTempTable("Climate");
sqlContext.sql("create table Climate as select * from Climate"); //Cria tabela permanente
//staxcsvs.write().saveAsTable("Climate"); Não testado, supostamente cria uma tabela permanente
