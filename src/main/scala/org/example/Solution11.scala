package org.example

object Solution11 {
  def main(args: Array[String]) {
    val x=Solution11(Array(2, 1, 1, 3, 2, 1, 1, 3))
    println(x)
  }

  def Solution11(A:Array[Double]): Double ={
    val len = A.length -1
    val unique = A.toSet


    def iterator(A:Array[Double],B:List[Array[Double]]=List(),i:Int=0,j:Int=0):List[Array[Double]] ={
      i match{
        case _ if i>len => B
        case _ if j>=len => iterator(A,A.slice(i,j+1)::B,i+1,i+1)
        case _ => iterator(A,A.slice(i,j+1)::B,i,j+1)
      }
    }
    ???

  }


}
