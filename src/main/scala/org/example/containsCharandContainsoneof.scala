package org.example

object containsCharandContainsoneof {

  def containsChar(c: Char, s: String) = s.contains(c)

  def containsOneOf(set: Seq[Char])(s: String) = set exists( c => containsChar(c, s))

  val containsUpperCaseChar = containsOneOf('A' to 'Z') _

  val containsLowerCaseChar = containsOneOf('a' to 'z') _

}
