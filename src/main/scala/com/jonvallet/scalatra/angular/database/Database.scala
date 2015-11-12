package com.jonvallet.scalatra.angular.database

import java.sql.{SQLException, Connection, DriverManager}
import java.util.Properties
import scala.io.StdIn.readLine

import org.h2.tools.Server

import org.slf4j.LoggerFactory

/**
 * Created by jon on 10/11/15.
 */
object Database {
  val logger = LoggerFactory.getLogger(getClass)
  val props : Properties = {
    val p = new Properties()
    p.put("user", "sa")
    p.put("password", "")
    p
  }
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
  def createConnection : Connection = {
    val conn = DriverManager.getConnection("jdbc:h2:~/test", props)

    conn.setAutoCommit(false)
    conn
  }
  def createSchema = {
    val connection = createConnection
    val s = connection.createStatement()
    s.execute("create table TODO(id int, name varchar(40), description varchar(255), done boolean)")
    connection.commit()
  }
  def main(args: Array[String]) = {
    startup
    println("Press any key to stop database")
    readLine()
    shutdown
  }
}
