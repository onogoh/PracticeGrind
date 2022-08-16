package org.example

object SortWith {
  val list = List(("Reggie Tennyson", 1), ("Mabel Spence", 3),
    ("Monty Bodkin", 12), ("Albert Peacemarch", 2))

  list sortWith {(x, y) =>x._1.length < y._1.length}

}
