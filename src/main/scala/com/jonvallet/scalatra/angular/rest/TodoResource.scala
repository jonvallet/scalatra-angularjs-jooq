package com.jonvallet.scalatra.angular.rest

import com.jonvallet.scalatra.angular.database.DatabaseContext
import com.jonvallet.scalatra.angular.repository.{TodoCreate, TodoRepository}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.{InternalServerError, Ok, ScalatraServlet}
import org.slf4j.LoggerFactory

import scala.util.{Failure, Success}

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
    val result = ctx.execute(todo, repository.create)
    result match {
      case Success(record) => Ok(record.id)
      case Failure(ex) => InternalServerError(ex)
    }
  }



  put("/:id/done") {
    val done = parsedBody.extract[Boolean]
    val id = params("id").toInt

    val result = ctx.execute((id, done), repository.updateDone)

    result match {
      case Success(id) => Ok(id)
      case Failure(ex) => InternalServerError(ex)
    }

  }

  delete("/:id") {
    val result = ctx.execute(params("id").toInt, repository.delete)

    result match {
      case Success(id) => Ok(id)
      case Failure(ex) => InternalServerError(ex)
    }
  }
}
