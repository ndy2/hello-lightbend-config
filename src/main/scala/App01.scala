import com.typesafe.config.{Config, ConfigFactory}

import scala.util.{Failure, Try}

object App01 extends App {
  println("========= ConfigFactory.load ===========")
  private val config: Config = ConfigFactory.load("app01.conf")

  println(config.getString("foo.a"))
  println(config.getString("foo.b"))

  println("\n========= Config.getConfig ===========")
  private val fooConfig: Config = config.getConfig("foo")

  println(fooConfig.getString("a"))
  println(fooConfig.getString("b"))

  println("\n========= config.getXXX - invalid ===========")

  Try {
    println(config.getInt("foo.a")) // foo.a is not integer
    println(config.getString("bar.a")) // no bar.a config
  } match {
    case Failure(exception) => println(exception.getMessage)
  }
}
