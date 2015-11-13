package com.jonvallet.scalatra.angular.repository

import java.util

import com.jonvallet.scalatra.angular.database.{DatabaseContext, Database}
import com.jonvallet.scalatra.angular.database.public_.Tables.TODO
import com.jonvallet.scalatra.angular.database.public_.tables.records.TodoRecord
import org.jooq.DSLContext
import org.jooq.impl.DSL

/**
 * Created by jon on 13/11/15.
 */
class TodoRepository(ctx : DatabaseContext) {
  def list(): util.List[TodoRecord] = {

    val result = ctx.create
      .select()
      .from(TODO)
      .fetchInto(classOf[TodoRecord])

    result
  }
  def create(record: TodoRecord): TodoRecord= {
    val newRecord = ctx.create.newRecord(TODO, record)
    newRecord.store()
    ctx.commit
    newRecord
  }
}
