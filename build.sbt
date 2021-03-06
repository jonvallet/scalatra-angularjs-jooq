import sbt._
import org.scalatra.sbt._

val Organization = "com.jonvallet"
val Name = "Scalatra Angular Web App"
val Version = "0.1.0-SNAPSHOT"
val ScalaVersion = "2.11.7"
val ScalatraVersion = "2.4.0"

lazy val root = (project in file("."))
  .settings(
    ScalatraPlugin.scalatraSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "org.eclipse.jetty" % "jetty-webapp" % "9.2.10.v20150310" % "container;compile",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s" %% "json4s-jackson" % "3.3.0",
        "org.jooq" % "jooq" % "3.7.1",
        "org.jooq" % "jooq-scala" % "3.7.1",
        "com.h2database" % "h2" % "1.4.190",
        "com.mchange" % "c3p0" % "0.9.5.1",
        "org.flywaydb" % "flyway-core" % "4.0"
      )
    )
  )

val stage = taskKey[Unit]("Stage task")

stage := {
  (assembly in Compile).value
}
