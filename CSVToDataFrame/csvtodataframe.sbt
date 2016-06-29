name := "CSVToDataFrame"

version :="1.0"

fork := true

scalaVersion :="2.10.4"

libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "1.5.0",
	"org.apache.spark" %% "spark-sql" % "1.5.0"
	)
