package org.example

object Implicits {
  implicit def housewife = "Housewife"
  def f(momName: String)(implicit worksAs: String)=
    println(s"Mom ${momName} works as ${worksAs}")

}
