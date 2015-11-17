package com.jonvallet.scalatra.angular.rest

import com.jonvallet.scalatra.angular.database.DatabaseContext
import com.jonvallet.scalatra.angular.repository.{TodoCreate, TodoRepository}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.{Ok, ScalatraServlet}
import org.slf4j.LoggerFactory

/**
 * Created by jon on 13/11/15.
 */
class TodoResource  extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats= DefaultFormats
  val logger = LoggerFactory.getLogger(getClass)
  lazy val ctx = DatabaseContext()
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
}
