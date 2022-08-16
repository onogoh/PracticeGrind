package org.example

import scala.annotation.tailrec

object ContainerMostWater {

  def maxArea(height: Array[Int]): Int = {

    val area:(Int,Int,Int)=>Int=(a,b,max)=>{
      (a*b).max(max)
    }
    @tailrec
    def iterate (start:Int,end:Int,max:Int):Int={
      end match{
        case _ if end ==start => max
        case _ => if (height(start)>=height(end))
          iterate(start,end-1,area(height(end),end-start,max))
        else iterate(start+1,end,area(height(start),end-start,max))
      }
    }
    iterate(0,height.length-1,0)
  }

}
