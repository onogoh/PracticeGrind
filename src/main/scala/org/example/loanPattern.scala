package org.example
import scala.io.Source
import scala.util.{Failure, Success, Try, Using}
object loanPattern {

  def autoCleanUp[T,A](f: A)(handler: A => T)(close: A=>Unit): T = {
    try { // 1
      handler(f) // 2
    }
    finally {
      println("Closing resource")
      close(f)
    }
  }
  def autoCleanUp2[T,A](f: A)(handler: A => T)(close: A=>Unit): Try[T] = {
    try { // 1
      Success(handler(f)) // 2
    }catch{
      case e:Exception => Failure(e)
    }
    finally {
      println("Closing resource")
      close(f)
    }
  }




}
