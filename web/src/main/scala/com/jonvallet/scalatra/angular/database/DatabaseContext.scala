package com.jonvallet.scalatra.angular.database

import java.sql.{DriverManager, Connection}
import java.util.Properties

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.jooq.{DSLContext, SQLDialect}
import org.jooq.impl.DSL

/**
 * Created by jon on 13/11/15.
 */
class DatabaseContext(connection: Connection, dialect: SQLDialect) {
  def create = DSL.using(connection, dialect)
  def commit = connection.commit()
  def rollback = connection.rollback()
}

