package com.jonvallet.scalatra.angular.repository


import com.jonvallet.scalatra.angular.database.DatabaseContext
import com.jonvallet.scalatra.angular.database.public_.tables.Todo._

import scala.collection.JavaConversions._
import org.jooq.scala.Conversions._

/**
 * Created by jon on 13/11/15.
 */
class TodoRepository(ctx : DatabaseContext) {

  val javaDao: TodoJavaDao = new TodoJavaDao(ctx)

  def list() : List[Todo] = {
    javaDao.getAll.toList
  }

  def create(todo: TodoCreate): Todo = {
    val newRecord = ctx.create.newRecord(TODO, todo)
    newRecord.store()
    Todo(newRecord.getId, newRecord.getName, newRecord.getDescription, newRecord.getDone)
  }

  def updateDone(id: Int, done: Boolean) = {
    //FIXME set does not work well with scala.
    //ctx.create.update(TODO).set(TODO.DONE, done).where(TODO.ID.eq(id))
    javaDao.updateDone(id, done);
  }
}

case class Todo (id: Integer, name: String, description: String, done: Boolean)
case class TodoCreate(name: String, description: String, done: Boolean)
