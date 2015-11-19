Seq(flywaySettings: _*)

val jdbcUrl = "jdbc:h2:~/test"
val user = "sa"
val password = ""

flywayUrl := jdbcUrl
flywayUser := "sa"

libraryDependencies += "com.h2database" % "h2" % "1.4.190"

