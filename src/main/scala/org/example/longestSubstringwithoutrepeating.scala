package org.example

object longestSubstringwithoutrepeating {
  import scala.annotation.tailrec
  import scala.collection.mutable.{Map=>mMap}
  def lengthOfLongestSubstring(s: String): Int = {

    val n= s.length
    @tailrec
    def tester(keys:mMap[Char,Int],start:Int, end:Int, max:Int):Int={
      end match{
        case _ if end ==n =>max
        case _ => keys.get(s(end)) match{
          case Some(x)=> tester(keys +=(s(end)->end),(x+1).max(start),end+1,max.max(end+1-start.max(x+1)))
          case _ => tester(keys +=(s(end)->end),start,end+1,max.max(end+1-start))
        }
      }

    }
    tester(mMap[Char, Int](), 0, 0, 0)

  }

}
