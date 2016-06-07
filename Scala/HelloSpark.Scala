/* HelloSpark.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.io._

object HelloSpark {
  def main(args: Array[String]) {
	val logFile = "../resources/1900.csv" // Should be some file on your system
    val conf = new SparkConf().setAppName("Hello Spark")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile) //segundo argumento é número de partições

    //arquivo será filtrado para uma estação
    val oneStationData = logData.map(line.split(',')).filter(line => fields(0) == "USC00300379")

    val tMax = oneStationData.map(line => line.split(',')).filter(line => fields(2) == "TMAX") //apenas temp maxima

	val resultsForTMax = tMax.map(fields => "TMAX", fields(1).substring(0, 4), fields(1).substring(4, 6), fields(1).substring(6, 8), fields(3))

	//ano, mês, dia (aaaammdd), valor coletado da temperatura (dezenas de graus Celsius(?) )

    val tMin = oneStationData.map(line => line.split(',')).filter(line => fields(2) == "TMIN")

    val resultsForTMin = tMin.map(fields => "TMIN", fields(1).substring(0, 4), fields(1).substring(4, 6), fields(1).substring(6, 8), fields(3))


    resultsForTMin.take(10).foreach(println)
    resultsForTMax.take(10).foreach(println)


  }
}
