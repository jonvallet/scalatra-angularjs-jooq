package com.jonvallet.scalatra.angular.database

import java.sql.{SQLException, Connection, DriverManager}
import java.util.Properties
import org.flywaydb.core.Flyway
import org.jooq.SQLDialect
import org.jooq.impl.DSL

import scala.io.StdIn.readLine

import org.h2.tools.Server

import org.slf4j.LoggerFactory

/**
 * Created by jon on 10/11/15.
 */
object Database {
  val logger = LoggerFactory.getLogger(getClass)

  val server = Server.createTcpServer()

  def startup = {
    logger.info("Starting h2 database")
    server.start()
    Class.forName("org.h2.Driver")
  }
  def shutdown = {
    logger.info("Stopping h2 database")
    server.stop()
  }

}
