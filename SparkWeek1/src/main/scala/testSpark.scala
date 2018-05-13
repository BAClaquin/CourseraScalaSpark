import org.apache.spark.sql.SparkSession

object testSpark {
  def main(args: Array[String]) {
    val logFile = "/home/bclaquin/text.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"\n\n\n\nLines with a: $numAs, Lines with b: $numBs\n\n\n\n")
    spark.stop()
  }
}