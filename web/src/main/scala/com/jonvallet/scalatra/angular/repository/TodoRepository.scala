package com.jonvallet.scalatra.angular.repository


import com.jonvallet.scalatra.angular.database.DatabaseContext
import com.jonvallet.scalatra.angular.database.public_.Tables.TODO

import scala.collection.JavaConversions._
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

  def create(todo: TodoCreate): Integer = {
    val newRecord = ctx.create.newRecord(TODO, todo)
    newRecord.store()
    newRecord.getId
  }
}

case class Todo (id: Integer, name: String, description: String, done: Boolean)
case class TodoCreate(name: String, description: String, done: Boolean)
