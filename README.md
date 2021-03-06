[![Build Status](https://travis-ci.org/jonvallet/scalatra-angularjs-jooq.svg?branch=master)](https://travis-ci.org/jonvallet/scalatra-angularjs-jooq)

[![Heroku Status](https://heroku-badge.herokuapp.com/?app=scalatra-angular-jooq)](https://scalatra-angular-jooq.herokuapp.com)
# Scalatra Angular Web App #
This is a sample project that uses scalatra as the backend for an angularjs
frontend web application.
## Build & Run ##
First, cd to the root of the project

```sh
$ cd scalatra-angularjs-jooq
```

Now, start the server container
```sh
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

If you modify the database, you can regenerate the helper classes running this command

```sh
$ cd codegen
$ bash generate-code.sh
```
## Standalone
You can ran the application as a Standalone java process

```
$./sbt assembly
$java -jar target/scala-2.11/**-assembly-**.jar
```