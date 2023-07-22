ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "hello-lightbend-config"
  )

libraryDependencies += "com.typesafe" % "config" % "1.4.2"
