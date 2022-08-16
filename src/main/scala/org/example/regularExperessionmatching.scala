package org.example

object regularExperessionmatching {

  val cache = scala.collection.mutable.HashMap[(Int, Int), Boolean]()

  def isMatch(s: String, p: String): Boolean = {
    val hkey = (s.hashCode, p.hashCode)

    (s, p) match {
      case ("", "") => true
      case (_, "") => false
      case (st, pt) if cache.contains(hkey) => cache(hkey)
      case (st, pt) => {
        val firstMatch = st.nonEmpty && (pt(0) == st(0) || pt(0) == '.')

        cache(hkey) = {
          if (pt.length >= 2 && pt(1) == '*') isMatch(st, pt.drop(2)) || (firstMatch && isMatch(st.tail, pt))
          else firstMatch && isMatch(st.tail, pt.tail)
        }

        cache(hkey)
      }
    }
  }

}
