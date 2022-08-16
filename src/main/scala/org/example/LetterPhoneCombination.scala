package org.example

object LetterPhoneCombination {
  val keyBoard = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )
  def letterCombinations(digits: String): List[String] = {
    def iterator(digits: String, acc: List[String]=List("")): List[String] = {
      digits match{
        case "" => acc
        case _ => iterator(digits.tail, acc.flatMap(comb => keyBoard(digits.head).map(chars=>comb+chars)))
      }
    }
    if (digits=="") return List[String]()
    iterator(digits)
  }

}
