package org.example

import scala.collection.mutable

object Solution7 {
  def main(args: Array[String]) {
//    val x=Solution7(Array(Array(1, 1, 1),Array(1, 3, 4),Array(1, 4, 3)))
//    val x=Solution7(Array(Array(0,1, 5, 0,0)))
    val x=Solution7(Array(Array(9, 1, 1, 0, 7),Array(1, 0, 2, 1, 0),Array(1, 9, 1, 1, 0)))

    println(x)
  }



  def Solution7(A:Array[Array[Int]]): Int ={
    val maxCol = A.head.length
    val maxRow = A.length
    val paths = new mutable.HashMap[String,String]()
    def indexFlatten(i:Int,j:Int):Int={
      maxCol*i + j
    }
    def canGo ( i:Int, j:Int,state:String):Boolean={
      j<maxCol && j>=0 && i>=0 && i < maxRow &&  !state.contains(indexFlatten(i,j).toChar)
    }

    def iterator (i:Int,j:Int,state:String="",step:Int=4,sum:String):Unit={
      step match{
        case _ if step <=1 => paths.addOne(state,sum)
        case _ => if (canGo(i,j+1,state)) {
          iterator(i,j+1,state.+(indexFlatten(i,j+1).toChar),step-1,sum+A(i)(j+1).toString)}
          if (canGo(i+1,j,state)) {
            iterator(i+1,j,state.+(indexFlatten(i+1,j).toChar),step-1,sum+A(i+1)(j).toString)}
          if (canGo(i-1,j,state)) {
            iterator(i-1,j,state.+(indexFlatten(i-1,j).toChar),step-1,sum+A(i-1)(j).toString)}
          if (canGo(i,j-1,state)) {
            iterator(i,j-1,state.+(indexFlatten(i,j-1).toChar),step-1,sum+A(i)(j-1).toString)}

      }
    }


    for(i <- 0 until maxRow; j <- 0 until maxCol){
      iterator(i,j,state=(indexFlatten(i,j).toChar).toString, sum = A(i)(j).toString)
    }

    paths.values.toArray.map(x=>x.toInt).max

  }


}
