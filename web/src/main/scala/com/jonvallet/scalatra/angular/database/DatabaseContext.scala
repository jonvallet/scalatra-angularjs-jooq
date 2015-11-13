package com.jonvallet.scalatra.angular.database

import java.sql.{DriverManager, Connection}
import java.util.Properties

import org.jooq.{DSLContext, SQLDialect}
import org.jooq.impl.DSL

/**
 * Created by jon on 13/11/15.
 */
class DatabaseContext(conn: Connection, props: Properties, dialect: SQLDialect ) {
  val dsl = DSL.using(conn, dialect)
  def create = dsl
  def commit = conn.commit()
  def rollback = conn.rollback()
}

object DatabaseContext {
  def apply() = {
    val jdbcUrl = "jdbc:h2:~/test"
    val props = new Properties()
    props.put("user", "sa")
    props.put("password", "")
    val connection = DriverManager.getConnection(jdbcUrl, props)
    connection.setAutoCommit(false)
    val dialect = SQLDialect.H2
    val dsl = DSL.using(connection, dialect)
    
    new DatabaseContext(connection, props, SQLDialect.H2)
  }
}
