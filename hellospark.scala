/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object SimpleApp {
  def main(args: Array[String]) {
	val logFile = "1900.csv" // Should be some file on your system
    val conf = new SparkConf().setAppName("Hello Spark").setMaster("local")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile).filter(line => line.length>0) //segundo argumento é número de partições

    //arquivo será filtrado para uma estação
    val oneStationData = logData.map(line => line.split(',')).filter(fields => fields(0) == "USC00300379")

    val tMax = oneStationData.filter(fields => fields(2) == "TMAX") //apenas temp maxima

	val resultsForTMax = tMax.map(fields => ("TMAX", fields(1).substring(0, 4), fields(1).substring(4, 6), fields(1).substring(6, 8), fields(3)))

	//ano, mês, dia (aaaammdd), valor coletado da temperatura (dezenas de graus Celsius(?) )

    val tMin = oneStationData.filter(fields => fields(2) == "TMIN")

    val resultsForTMin = tMin.map(fields => ("TMIN", fields(1).substring(0, 4), fields(1).substring(4, 6), fields(1).substring(6, 8), fields(3)))


    resultsForTMin.take(10).foreach(println)
    resultsForTMax.take(10).foreach(println)

    sc.stop
  }
}
