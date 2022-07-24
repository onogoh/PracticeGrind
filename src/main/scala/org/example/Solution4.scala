package org.example


object Solution4 {
  def main(args: Array[String]) {
    val x=Solution4(Array(2, 4, 1, 6, 5, 9, 7))
    println(x)
  }

  def Solution4(C:Array[Int]): Boolean ={
    val len = C.length
    val sum = C.sum

    if (len<5 || len > 10000){
      return false
    }
    var sumFirst = C(0)
    var sumSecond = C(len-1)
    val sumThird =(i:Int,j:Int) => sum-sumFirst-sumSecond-C(i)-C(j)

    def iterator(i:Int=1,j:Int=len-2):Boolean={
      i match {
        case _ if (i > C.length - 3) || (j<=i+1)  => false
        case _ if sumFirst < sumSecond =>
          sumFirst+=C(i)
          iterator(i+1,j)
        case _ if sumFirst > sumSecond =>
          sumSecond+=C(j)
          iterator(i,j-1)
        case _ =>
          if (sumThird(i,j)==sumFirst){
            true
          } else {
            sumFirst+=C(i)
            sumSecond+=C(j)
            iterator(i+1,j-1)
          }
      }
    }
    iterator()
  }
}
