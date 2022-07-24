package org.example

object Solution5 {
  def main(args: Array[String]) {
    val x=Solution5(2, 4, 1, 6)
    println(x)
  }
  def gcd (a:Int,b:Int):Int={
    if (b==0)
      return a
    gcd(b,a%b)

  }

  def Solution5(ax:Int,ay:Int,bx:Int,by:Int): String ={
    val uy = by-ay
    val ux = bx -ax
    val gcdValue = gcd(Math.abs(ux), Math.abs(uy))
     (bx + uy / gcdValue).toString + "," +(by - ux / gcdValue).toString
  }


}
