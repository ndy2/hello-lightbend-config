import com.typesafe.config.{Config, ConfigFactory}

object App03 extends App {
  private val config: Config = ConfigFactory.load("app03.conf")
  println("\n========= ConfigFactory.load ===========")
  println("=== load from environment variable  ===")
  println(config.getString("java.home")) // "C:\Program Files\Java\jdk-17"
  println(config.getObject("os")) // "SimpleConfigObject({"arch":"amd64","name":"Windows 11","version":"10.0"})"

  println("\n========= ConfigFactory.load ===========")
  println("= configured in both env variable & conf file =")

  println(config.getString("java.home")) // "C:\Program Files\Java\jdk-17" - env variable win by default
  println(config.getString("java.house")) // "app03-javahouse"
}
