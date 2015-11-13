import sbt._
import org.scalatra.sbt._

val Organization = "com.jonvallet"
val Name = "Scalatra Angular Web App"
val Version = "0.1.0-SNAPSHOT"
val ScalaVersion = "2.11.7"
val ScalatraVersion = "2.4.0.RC3"



lazy val model = project.
  settings(
    libraryDependencies ++= Seq(
      "org.jooq" % "jooq-codegen" % "3.3.1",
      "com.h2database" % "h2" % "1.4.190"
    )
  )

lazy val web = project
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
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "9.2.10.v20150310" % "container",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s" %% "json4s-jackson" % "3.3.0",
        "org.webjars" % "angularjs" % "1.4.7",
        "org.webjars" % "bootstrap" % "3.3.5",
        "org.jooq" % "jooq" % "3.3.1",
        "org.jooq" % "jooq-meta" % "3.3.1",
        "org.jooq" % "jooq-codegen" % "3.3.1"

      )
    )
  )



