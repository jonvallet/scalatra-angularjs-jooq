[![Build Status](https://travis-ci.org/jonvallet/scalatra-angularjs-jooq.svg?branch=master)](https://travis-ci.org/jonvallet/scalatra-angularjs-jooq)
# Scalatra Angular Web App #
This is a sample project that uses scalatra as the backend for an angularjs
frontend web application.
## Build & Run ##
First, cd to the root of the project

```sh
$ cd scalatra-angularjs-jooq
```

If this your first time, you will need to create the database schema first.

```sh
$ ./sbt flywayMigrate
```

Now, start the server container
```sh
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

If you modify the database, you can regenerate the helper classes running this command while in a sbt session

```sh
$ ./sbt
> runMain org.jooq.util.GenerationTool jooq-config.xml
```