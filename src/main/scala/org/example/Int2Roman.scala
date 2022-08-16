package org.example

object Int2Roman {
  val numbers = Seq( (1000, "M"),(900, "CM"),(500, "D"),(400, "CD"),(100, "C"),(90, "XC"),(50, "L"),
    (40, "XL"),(10, "X"),(9, "IX"),(5, "V"),(4, "IV"),(1, "I"))
  def intToRoman(num: Int): String = {
    def iterate(num:Int=num, romans: Seq[(Int,String)]=numbers,agg:String=""): String = {
      romans match {
        case (x, y) :: _ if num > x => iterate(num-x, romans,agg++y)
        case (x, y) :: _ if x == num => agg++y
        case (x, _) :: tail if x > num => iterate(num, tail,agg)
      }
    }
    iterate()
  }

}
