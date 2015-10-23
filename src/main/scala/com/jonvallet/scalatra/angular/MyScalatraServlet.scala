package com.jonvallet.scalatra.angular

import java.util.Date

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport

class MyScalatraServlet extends ScalatraAngularWebAppStack with JacksonJsonSupport {
  implicit lazy val jsonFormats: Formats= DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/") {
    Map("Name"->"Scalatra Service",
        "Version"->"0.1",
        "Build Time"-> new Date())
 }


}
