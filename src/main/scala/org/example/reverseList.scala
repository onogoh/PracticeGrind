package org.example

import scala.annotation.tailrec

object reverseList {

  @tailrec
  def reverseList(list: List[Int], acc: List[Int]) : List[Int] = list match {
    case head :: tail => reverseList(tail, head :: acc)
    case Nil => acc
  }

}
