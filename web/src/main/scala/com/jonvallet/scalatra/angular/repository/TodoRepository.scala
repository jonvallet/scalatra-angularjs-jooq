package com.jonvallet.scalatra.angular.repository

import java.util

import com.jonvallet.scalatra.angular.database.Database
import com.jonvallet.scalatra.angular.database.public_.Tables.TODO
import com.jonvallet.scalatra.angular.database.public_.tables.records.TodoRecord
import org.jooq.DSLContext

/**
 * Created by jon on 13/11/15.
 */
class TodoRepository(dsl : DSLContext) {
  def list(): util.List[TodoRecord] = {

    val result = dsl
      .select()
      .from(TODO)
      .fetchInto(classOf[TodoRecord])

    result
  }
  def create(record: TodoRecord): Int= {
    dsl.newRecord(TODO, record).store()
  }
}
