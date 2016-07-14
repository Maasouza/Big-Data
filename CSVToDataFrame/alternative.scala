import java.sql.Timestamp
import sqlContext.implicits._

//Modelo de registro para a tabela de saída
case class Register(Estacao:String,Data:Timestamp,Tipo:String,Valor:Int,Latitude:Float,Longitude:Float);

//Abre o arquivo que contém as estações, latitude e longitude de cada registro, o transforma em uma RDD
val station = sc.textFile("wasb://stations@datagrupo8.blob.core.windows.net/ghcnd-stations.txt").
map(l=>(l.substring(0,11),
    (l.substring(12,20).trim.toFloat,
    l.substring(21,30).trim.toFloat
       )));
station.take(10).foreach(println);

//Abre todos os csvs da pasta específicada, os mapeia numa rdd
val csvs = sc.textFile("wasb://datasets@datagrupo8.blob.core.windows.net/*.csv").map(
l=>(l.split(",")(0),(
new Timestamp(l.split(",")(1).substring(0,4).toInt-1900,
              l.split(",")(1).substring(4,6).toInt-1,
              l.split(",")(1).substring(6,8).toInt,0,0,0,0),
              l.split(",")(2),l.split(",")(3).toInt
              )));
//Produz um dataframe com o conteúdo dos csvs e os dados espaciais das estações
val staxcsvs = csvs.join(station).map(l=>Register(l._1,l._2._1._1,l._2._1._2,l._2._1._3,l._2._2._1,l._2._2._2)).toDF;

//Salva o resultado em um arquivo parquet
staxcsvs.take(10).foreach(println);
staxcsvs.write.save("wasb://data@datagrupo8.blob.core.windows.net/dados.parquet");

//lê um arquivo parquet
val df = sqlContext.read.load("wasb://data@datagrupo8.blob.core.windows.net/dados.parquet")
df.registerTempTable("Climate");
sqlContext.sql("create table Climate as select * from Climate"); //Cria tabela permanente
//staxcsvs.write().saveAsTable("Climate"); Não testado, supostamente cria uma tabela permanente
