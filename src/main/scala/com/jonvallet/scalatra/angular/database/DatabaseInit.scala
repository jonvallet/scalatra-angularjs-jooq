package com.jonvallet.scalatra.angular.database

import java.sql.{SQLException, Connection, DriverManager}

import org.apache.derby.jdbc.EmbeddedDriver
import org.slf4j.LoggerFactory

/**
 * Created by jon on 10/11/15.
 */
trait DatabaseInit {
  val logger = LoggerFactory.getLogger(getClass)

  def startup = {
    logger.info("Creating derby embedded driver")
    new EmbeddedDriver
    DriverManager.getConnection("jdbc:derby:derbyDb;create=true")
  }
  def shutdown = {
    logger.info("Stopping derby embedded driver")
    DriverManager.getConnection("jdbc:derby:derbyDb;shutdown=true")
  }
}

object Database {
  val logger = LoggerFactory.getLogger(getClass)
  def createConnection : Connection = {
    val conn = DriverManager.getConnection("jdbc:derby:derbyDb")

    conn.setAutoCommit(false)
    conn
  }
  def createSchema = {
    val connection = createConnection
    val s = connection.createStatement()

    try {
      s.execute("create table TODO(id int, name varchar(40), description varchar(255), done boolean)")
      connection.commit()
    } catch  {
      case e : SQLException if e.getSQLState == "X0Y32" => logger.info("Schema already created.")
    }
  }
}
