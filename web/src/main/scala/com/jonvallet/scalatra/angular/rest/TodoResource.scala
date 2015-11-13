package com.jonvallet.scalatra.angular.rest

import com.jonvallet.scalatra.angular.database.{DatabaseContext, Database}
import com.jonvallet.scalatra.angular.database.public_.tables.records.TodoRecord
import com.jonvallet.scalatra.angular.repository.TodoRepository
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.{Ok, ScalatraServlet}
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.LoggerFactory
import org.json4s._

/**
 * Created by jon on 13/11/15.
 */
class TodoResource  extends ScalatraServlet with JacksonJsonSupport {

  implicit lazy val jsonFormats: Formats= DefaultFormats
  val logger = LoggerFactory.getLogger(getClass)
  lazy val repository = new TodoRepository(DatabaseContext())

  before("/*") {
    contentType = formats("json")
  }

  get() {
    repository.list()
  }

  post() {
    val json = parse(request.body)

    logger.info(s"Trying to save $json")

//    val record = json.extract[TodoRecord]

//    logger.info(s"Record to save $record")
    val record = repository.create(new TodoRecord(null,"name", "description", false))
    Ok(record)
  }
}
