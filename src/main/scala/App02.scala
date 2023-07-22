import com.typesafe.config.{Config, ConfigFactory}

import scala.util.{Failure, Try}

/**
 * run with VM arguments
 * -Dconfig.resource=app02-haha.conf -Dhoho.popo=hohopopo
 */
object App02 extends App {
  println("========= ConfigFactory.load ===========")
  private val config: Config = ConfigFactory.load("app02.conf")
  println(config.getString("foo.a"))
  println(config.getString("foo.b")) // include works well

  println(config.getString("bar.a"))
  println(config.getString("bar.b"))


  println("\n========= ConfigFactory.load ===========")
  println("=== override default with VM argument -Dconfig.resource=app02-haha.conf ===")
  private val hahaConfig: Config = ConfigFactory.load()
  println(hahaConfig.getString("haha.a")) // bonjour
  println(hahaConfig.getString("haha.b")) // lgbn-conf

  println("\n========= ConfigFactory.load ===========")
  println("=== supply new config : -Dhoho.popo=hohopopop  ===")
  println(config.getString("hoho.popo")) // "hohopopo"
  println(hahaConfig.getString("hoho.popo")) // "hohopopo"
}
