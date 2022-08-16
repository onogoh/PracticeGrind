package org.example

import scala.annotation.tailrec

object groupingContinous {
  def main(args: Array[String]) {
    groupNumbers(List(1,2,4,5,9,10))
  }
  def check (x:Int,y:Int):Boolean={
    y-x>=0 && y-x<=1
  }

  def groupNumbers(list: List[Int]): List[List[Int]] = {
    @tailrec
    def groupThem(lst: List[Int], result: List[List[Int]], acc: List[Int]): List[List[Int]] = lst match {
      case Nil => acc.reverse :: result
      case x :: xs =>
        acc match {
          case Nil => groupThem(xs, result, x :: acc)
          case y :: ys if check(x,y) =>

            groupThem(xs, result, x :: acc)

          case _ =>
            groupThem(xs, acc.reverse :: result, x :: List())
        }
    }
    val r = groupThem(list, List(), List())
    r.reverse
  }


}
