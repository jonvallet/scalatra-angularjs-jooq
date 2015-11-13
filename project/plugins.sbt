addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.4.0")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "3.2.1")

resolvers += "Flyway" at "http://flywaydb.org/repo"

resolvers += "sean8223 Releases" at "https://github.com/sean8223/repository/raw/master/releases"
addSbtPlugin("sean8223" %% "jooq-sbt-plugin" % "1.6")// see above
