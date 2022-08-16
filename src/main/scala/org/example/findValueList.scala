package org.example

import scala.annotation.tailrec

object findValueList {

  @tailrec
  def firstMatching[T](xs: List[T])(f: (T) => Boolean): Option[T] = xs match {
    case Nil => None
    case x :: ts => if (f(x)) Some(x) else firstMatching(ts)(f)
  }

}
