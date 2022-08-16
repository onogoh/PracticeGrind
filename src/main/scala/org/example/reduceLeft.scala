package org.example

import scala.annotation.tailrec

object reduceLeft extends App {
  def reduceLeft(l: List[String], f: (String, String) => String) = {
    @tailrec
    def reduceIt(acc: String, list: List[String]) : String = list match    {
      case Nil => acc
      case x :: xs => reduceIt(f(acc, x), xs)
    }
    reduceIt(l.head, l.tail) // 1
  }

  val nums = (1 to 20).toList map { _.toString }

  def f(acc: String, s: String) = s"(${acc} - ${s})"

  val result = reduceLeft(nums, f) // 2

  println(result)

  def reduceRight(l: List[String], f: (String, String) => String): String = l match {
    case Nil => throw new IllegalArgumentException("Bad List") // 1
    case y :: Nil => y // 2
    case x :: xs => f(x, reduceRight(xs, f)) // 3
  }

  val nums1 = (1 to 3).toList map { _.toString }

  def f1(s: String, acc: String) = s"(${s} - ${acc})"

  val result1 = reduceRight(nums, f1)

  println(result)

}
