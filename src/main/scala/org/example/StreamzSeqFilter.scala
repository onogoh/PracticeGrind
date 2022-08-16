package org.example

object StreamzSeqFilter extends App{

  def succ(n: Int):Stream[Int] = n #:: succ(n+1)
  lazy val r = succ(4)

  val p = List("", "9#greaT", "is great", "greater", "23#pp", "Aa#@4")
  val pv=p.view.filterNot (_.isEmpty) .filter (_.exists(_.isDigit))
    .filter (_.exists(_.isUpper))
    .filter (_.matches( """^.*[\W].*$"""))
    .filter (_.length >= 5)

}
