package org.example

import scala.collection.mutable


object Solution3 {
  def main(args: Array[String]) {
    val x=Solution3(Array(2, 4, 1, 6, 5, 9, 7))
    println(x)
  }

  def Solution3(C:Array[Int]): Int ={
    val len = C.length-1
    if (len<=1){
      return len
    }
    def swap(index:Int):Unit={
      val temp = C(index-1)
      C(index-1)=C(index)
      C(index) = temp
    }

    def iterator(i:Int=1,j:Int=0,count:Int=1):Int={
      i match {
        case _ if i == len => count
        case _ if (j>=2) => swap(j);if (C(j-1)< C(j-2)) iterator(i,j-1,count-1) else iterator(i+1,0,count)
        case _ if C(i)>= C(i-1) && j<2 => iterator(i+1,j,count+1)
        case _ if C(i) < C(i-1) =>
          iterator(i,i,count)
      }
    }
    iterator()
  }
}
