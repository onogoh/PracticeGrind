package org.example

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
   }
trait ListX
case object EmptyNode extends ListX
case class Node[T](head: T, tail: ListX) extends ListX

object addTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def add (a:Int,b:Int,c:Int=0):(Int,Int)={
      ((a+b+c)%10,(a+b+c)/10)
    }
    def iterator(a1:ListNode=l1,b1:ListNode=l2,carry:Int=0,agg:ListNode=null):ListNode ={
      (a1,b1, carry) match {
        case (null,null,0) => agg
        case (null,null,_)=> new ListNode(carry,agg)
        case (null,_,_) =>{val tuple=add(0,b1.x,carry)
          iterator(null,b1.next,tuple._2,new ListNode(tuple._1,agg))
        }
        case (_,null,_) =>{val tuple=add(a1.x,0,carry)
          iterator(a1.next,null,tuple._2,new ListNode(tuple._1,agg))
        }
        case (_,_,_) => {val tuple=add(a1.x,b1.x,carry)
          iterator(a1.next,b1.next,tuple._2,new ListNode(tuple._1,agg))
        }
      }

    }
    def reverse (a1:ListNode,agg:ListNode=null):ListNode ={
      a1 match{
        case null => agg
        case _ => reverse(a1.next,new ListNode(a1.x,agg))
      }

    }
    reverse(iterator())

  }

}
