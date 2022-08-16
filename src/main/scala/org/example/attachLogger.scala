package org.example

object attachLogger {

  def attach_logger[X, Y](f: (X) => Y)(arg: X): Y = { // 1
    println("arg = " + arg.toString)
    println("Calling the function...")
    val result = f(arg)  // 2
    println("function call returned...")

    result
  }




}
