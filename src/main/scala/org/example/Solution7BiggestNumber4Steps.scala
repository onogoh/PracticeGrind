package org.example

import scala.collection.mutable

object Solution7BiggestNumber4Steps {
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
    def canGo ( i:Int, j:Int,key:String):Boolean={
      j<maxCol && j>=0 && i>=0 && i < maxRow &&  !key.contains(indexFlatten(i,j).toChar)
    }

    def iterator (i:Int,j:Int,key:String="",step:Int=4,value:String):Unit={
      step match{
        case _ if step <=1 => paths.addOne(key,value)
        case _ => if (canGo(i,j+1,key)) {
          iterator(i,j+1,key.+(indexFlatten(i,j+1).toChar),step-1,value+A(i)(j+1).toString)}
          if (canGo(i+1,j,key)) {
            iterator(i+1,j,key.+(indexFlatten(i+1,j).toChar),step-1,value+A(i+1)(j).toString)}
          if (canGo(i-1,j,key)) {
            iterator(i-1,j,key.+(indexFlatten(i-1,j).toChar),step-1,value+A(i-1)(j).toString)}
          if (canGo(i,j-1,key)) {
            iterator(i,j-1,key.+(indexFlatten(i,j-1).toChar),step-1,value+A(i)(j-1).toString)}

      }
    }


    for(i <- 0 until maxRow; j <- 0 until maxCol){
      iterator(i,j,key=indexFlatten(i,j).toChar.toString, value = A(i)(j).toString)
    }

    paths.values.toArray.map(x=>x.toInt).max

  }


}
