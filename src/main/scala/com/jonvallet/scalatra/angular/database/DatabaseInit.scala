package com.jonvallet.scalatra.angular.database

import java.sql.DriverManager

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
