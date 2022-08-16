package org.example

import scala.collection.mutable

/**
 * Hello world!
 *
 */

object Solution1Laser {
  case class Point(x:Double,y:Double)

  def main(args: Array[String]) {
    println("Hello World!")
  }

  def Solution(a: Array[Point]): Int ={
    val hash = new mutable.HashMap[(Double,Int),Int]()
    def unitVector(a: Point): Double = {
      a.y / a.x
    }
    def quadrant(a:Point) :(Double,Int) ={
      unitVector(a) match{
        case x if x>0 => if (a.x<0) (x,1) else (x,2)
        case x if x<0 => if (a.x<0) (x,1) else (x,2)
      }
    }
    def iterator(a:Array[Point]):Unit={
      a match {
        case _ if a.isEmpty =>
        case _ if hash.contains(quadrant(a.head)) =>
          iterator(a.tail)
        case _ => hash.addOne(quadrant(a.head),1)
          iterator(a.tail)
      }
    }
    iterator(a)
    hash.size
  }
}
