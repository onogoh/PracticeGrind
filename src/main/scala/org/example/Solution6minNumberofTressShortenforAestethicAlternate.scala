package org.example

object Solution6minNumberofTressShortenforAestethicAlternate {
  def main(args: Array[String]) {
    val x=Solution6(Array(2, 4, 1, 6))
    println(x)
  }
  def protruded (idx:Int,A:Array[Int]):Boolean={
    val isLeftProtruded = idx > 0 && A(idx) >= A(idx - 1)
    val isRightProtruded = idx < A.length - 1 && A(idx) >= A(idx + 1)
    isLeftProtruded || isRightProtruded
  }

  def Solution6(A:Array[Int]): Int ={
    val count1 = A.zipWithIndex.map(x => x._2% 2 == 0 && protruded(x._2, A)).length
    val count2 = A.zipWithIndex.map(x => x._2% 2 == 1 && protruded(x._2, A)).length
     Math.min(count1, count2)

  }


}
