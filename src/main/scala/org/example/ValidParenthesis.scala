package org.example

object ValidParenthesis {
  import scala.collection.mutable.Stack
  val cache =Map('('->')','{'->'}','['->']')
  val keys = cache.keys.toSet

  def isValid(s: String): Boolean = {
    val q = Stack[Char]()
    def iterator(s:String) :Boolean ={
      s match{
        case "" =>if(q.isEmpty){true}else{false}
        case _ if (keys contains s.head) => q.push(s.head);iterator(s.tail)
        case _ if (!(keys contains s(0)) && q.nonEmpty&& cache(q.head)==s(0)) =>q.pop;iterator(s.tail)
        case _ => false
      }
    }
    iterator(s)
  }
}
