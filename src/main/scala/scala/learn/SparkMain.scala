package scala.learn

import org.apache.spark.sql.SparkSession

object SparkMain {

  def main(args: Array[String]): Unit = {

    var spark : SparkSession= null

     if(args(0)=="1"){
      spark=SparkSession
      .builder()
      .enableHiveSupport()
      .appName("Test App")
      .master("spark://hdpmaster:7077")
      .getOrCreate()}else if (args(0)=="2"){
       spark=SparkSession
         .builder()
         .config("spark.sql.warehouse.dir","hdfs://10.0.2.15:9000/user/hive/warehouse")
         .enableHiveSupport()
         .appName("Test App")
         .master("spark://hdpmaster:7077")
         .getOrCreate()

     } else {

       spark=SparkSession
         .builder().config("hive.metastore.uris","thrift://localhost:9083")
         .config("spark.sql.warehouse.dir","hdfs://10.0.2.15:9000/user/hive/warehouse/")
         .appName("Test App")
         .master("spark://hdpmaster:7077")
         .getOrCreate()

     }

    spark.sql("show databases").show()
    spark.close()


  }

}
