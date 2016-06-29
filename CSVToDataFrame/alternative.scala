import java.sql.Timestamp
import sqlContext.implicits._

case class Register(column0:String,column1:Timestamp,column2:String,column3:Int);

val csvdf = sc.textFile("wasb:///2015.csv").map(
l=>Register(l.split(",")(0),
new Timestamp(l.split(",")(1).substring(0,4).toInt-1900,l.split(",")(1).substring(4,6).toInt-1,l.split(",")(1).substring(6,8).toInt,0,0,0,0),
l.split(",")(2),l.split(",")(3).toInt)).toDF();

csvdf.take(10).foreach(println);
csvdf.registerTempTable("Climate");
