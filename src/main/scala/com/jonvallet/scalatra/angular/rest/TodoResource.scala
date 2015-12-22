package com.jonvallet.scalatra.angular.rest

import java.sql.Connection

import com.jonvallet.scalatra.angular.database.DatabaseContext
import com.jonvallet.scalatra.angular.repository.{TodoCreate, TodoRepository}
import org.jooq.SQLDialect
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.{Ok, ScalatraServlet}
import org.slf4j.LoggerFactory

/**
 * Created by jon on 13/11/15.
 */
class TodoResource(ctx: DatabaseContext)  extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats= DefaultFormats
  val logger = LoggerFactory.getLogger(getClass)
  lazy val repository = new TodoRepository(ctx)


  before("/*") {
    contentType = formats("json")
  }

  get() {
     repository.list()
  }

  post() {
    val todo = parsedBody.extract[TodoCreate]
    val record = repository.create(todo)
    ctx.commit

    Ok(record)
  }

  put("/:id/done") {
    val done = parsedBody.extract[Boolean]
    val id = params("id").toInt
    repository.updateDone(id, done)
    ctx.commit
    Ok()
  }

  delete("/:id") {
    repository.delete(params("id").toInt)
    ctx.commit
    Ok()
  }
}
