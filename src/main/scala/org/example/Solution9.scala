package org.example

object Solution9 {
  def main(args: Array[String]) {
    val x=Solution9(Array("test1a", "test2", "test1b", "test1c", "test3"),Array("Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"))
    println(x)
  }
  def groupID (a:String):String={
    val r = "\\d+".r
    r.findFirstIn(a).get
  }

  def Solution9(A:Array[String],B:Array[String]): Double ={
    val zippedValue=A.zip(B).map(a=>(groupID(a._1),a._2)).groupBy(x=>x._1.toInt)
    val xx=zippedValue.map(a=> a._2.forall(x=>x._2=="OK"))
    val length = xx.size.toDouble
    val right=xx.count(x => x).toDouble
    right/length*100
  }


}
