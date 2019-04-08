package scala.learn

import scala.util.{Failure, Success, Try}

class OptionDemo {

  def methodm(sourceType: String, path: String)(
      implicit readSource: ReadSource): Try[Unit] = {
    sourceType.toLowerCase match {
      case "hive" => Try { readSource.readFromHive(path) }
      case "file" => Try { readSource.readFromFS(path) }
      case _ => Try{throw new Exception("Invalid Source Exception")}
    }
  }

}

object OptionDemo {
  /*def main(args: Array[String]): Unit = {
    var obj = new OptionDemo()
    implicit val readSource = new ReadSource
    var result = obj.methodm("Hie", "TestPath")
    result match {
      case Success(pass) => println("Method call was success")
      case Failure(fail) => {
        println("Invalid Source")
        println("============================================")
        println(fail.getMessage)
        println("============================================")

      }
    }
  }*/
}
