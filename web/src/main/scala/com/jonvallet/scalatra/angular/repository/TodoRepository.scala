package com.jonvallet.scalatra.angular.repository


import com.jonvallet.scalatra.angular.database.{DatabaseContext, Database}
import com.jonvallet.scalatra.angular.database.public_.Tables.TODO
import com.jonvallet.scalatra.angular.database.public_.tables.records.TodoRecord
import org.jooq.DSLContext
import org.jooq.impl.DSL
import collection.JavaConversions._
import org.jooq.scala.Conversions._

/**
 * Created by jon on 13/11/15.
 */
class TodoRepository(ctx : DatabaseContext) {
  def list() : List[Todo] = {

    val result = ctx.create
      .select()
      .from(TODO)
      .fetchInto(classOf[Todo])

    result.toList
  }

  def create(record: TodoRecord): TodoRecord= {
    val newRecord = ctx.create.newRecord(TODO, record)
    newRecord.store()
    ctx.commit
    newRecord
  }
}

case class Todo (id: Long, name: String, description: String, done: Boolean)
