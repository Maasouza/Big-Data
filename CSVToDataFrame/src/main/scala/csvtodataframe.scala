/* csvtodataframe.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf



object CSVToDataFrame {
  def main(args: Array[String]) {
	val logFile = "1900.csv" // Should be some file on your system
    val conf = new SparkConf().setAppName("CSVToDataFrame").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._
    val df = sqlContext.read.format("com.databricks.spark.csv")
        .option("header", "false") //dont use first line of file as heder
        .option("inferSchema", "true") //automatically infer data types
        .load(logFile)

    df.show(10, false)
    sc.stop

  }
}
