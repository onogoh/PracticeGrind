package org.example

object Solution10SubArraywithMean {
  def main(args: Array[String]) {
    val x=Solution10(Array(2,1,3),2)
    println(x)
  }

  def Solution10(A:Array[Double],num:Double): Double ={
    val len = A.length -1

    def average(A:Array[Double])(num:Double=num):Boolean={
      math.abs(A.sum/A.length - num) <=0.0001
    }

    def iterator(A:Array[Double],B:List[Array[Double]]=List(),i:Int=0,j:Int=0):List[Array[Double]] ={
      i match{
        case _ if i>len => B
        case _ if j>=len => iterator(A,A.slice(i,j+1)::B,i+1,i+1)
        case _ => iterator(A,A.slice(i,j+1)::B,i,j+1)
      }
    }
    iterator(A).count(x=>average(x)(num))
  }


}
