package com.jonvallet.scalatra.angular.database

import org.jooq.util.GenerationTool

/**
  * Created by j.vallet@validus-ivc.co.uk on 22/12/15.
  */
object GenerateHelperClasses {

  def main (args: Array[String]) = {
    println ("Creating database helper classes")
    GenerationTool.main(args)
  }

}
