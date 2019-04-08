package scala.learn

import org.apache.spark.sql.SparkSession

object SparkMain {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder().config("hive.metastore.uris","thrift://127.0.1.1:9083")
      .appName("Test App")
      .enableHiveSupport()
      .master("local[*]")
      .getOrCreate()

  }

}
