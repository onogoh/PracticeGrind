package org.example

import scala.collection.mutable

object twoSum {

  import scala.annotation.tailrec
  import scala.collection.mutable.{Map => mMap}
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val keys =mMap[Int,Int]()
    @tailrec
    def iterate(pos: Int): Array[Int] = {
      keys += (nums(pos)->pos)
      keys.get(target - nums(pos+1)) match {
        case Some(x) =>
          Array[Int](x, pos+1)
        case _ =>
          iterate(pos + 1)
      }

    }

    iterate(0)
  }

  def twoSums(nums: Array[Int], target: Int): Array[Int] = {
    val len = nums.length-1
    val hash = new mutable.HashMap[Int,Int]()
    def iterator2(i:Int=0,a:List[Int]=List[Int]()):List[Int]={
      i match {
        case _ if (i>len) => a
        case _ if hash.contains(target-nums(i)) =>hash(target-nums(i))::(i::a)
        case _ if !(hash.contains(target-nums(i))) => {hash put (nums(i),i)
          iterator2(i+1,a)}
      }
    }
    iterator2().toArray

  }

}
