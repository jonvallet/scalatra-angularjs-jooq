libraryDependencies ++= Seq(
    "com.h2database" % "h2" % "1.4.190"
)

seq(flywaySettings: _*)
seq(jooqSettings:_*)

val jdbcUrl = "jdbc:h2:~/test"
val user = "sa"
val password = ""

flywayUrl := jdbcUrl
flywayUser := "sa"

libraryDependencies += "com.h2database" % "h2" % "1.4.190"

jooqOptions := Seq("jdbc.driver" -> "org.h2.Driver",
                    "jdbc.url" -> jdbcUrl,
                    "jdbc.user" -> user,
                    "jdbc.password" -> password,
                    "generator.database.name" -> "org.jooq.util.h2.H2Database",
                    "generator.database.inputSchema" -> "sa",
                    "generator.target.packageName" -> "com.jonvallet.scalatra.angular.database")
