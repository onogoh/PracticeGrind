package org.example

import scala.collection.mutable

/**
 * Hello world!
 *
 */

object Solution2 {
  def main(args: Array[String]) {
    println("Hello World!")
  }

  def Solution2(U:Int,L:Int,C:Array[Int]): String ={
    if (U+L-C.sum !=0){
      return "IMPOSSIBLE"
    }
    val up =new StringBuilder("")
    val down=new StringBuilder("")

    def iterator(vals:Array[Int],U:Int,L:Int):Unit={
      vals match {
        case _ if vals.isEmpty => ()
        case _ if vals.head==2 => up+='1';down+='1'
          iterator(vals.tail,U-1,L-1)
        case _ if vals.head==0 => up+='0';down+='0'
          iterator(vals.tail,U,L)
        case _ if vals.head==1 && U>0=> up+='1';down+='0'
          iterator(vals.tail,U-1,L)
        case _ if vals.head==1 && L>0=> up+='0';down+='1'
          iterator(vals.tail,U,L-1)
      }
    }
    iterator(C,U,L)
     up + "," + down
  }
}
