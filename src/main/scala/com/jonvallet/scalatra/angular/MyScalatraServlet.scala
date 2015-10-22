package com.jonvallet.scalatra.angular

import java.util.Date

class MyScalatraServlet extends ScalatraAngularWebAppStack {

  get("/") {
    Map("Name"->"Scalatra Service",
        "Version"->"0.1",
        "Build Time"-> new Date())
 }


}
