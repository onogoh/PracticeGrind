package org.example

import scala.util.{Failure, Success, Try}

object decoratorPattern {

  trait DB {
    def getData(k: String): String
    def putData(k: String, v: String): Unit
    def deleteData(k: String): Unit
  }
  trait Walks {
    def name : String
    def walk() =
      println(name + "is having a stroll now")
  }
  trait GoodsMover {
    def name : String
    def moveGoods() =
      println(name + "busy moving heavy stuff")
  }
  abstract class Animal(val rating: Int,_name:String)extends Ordered[Animal] {
    def giveInoculation(): Unit  // abstract method
    def alreadyInoculated() : Boolean // abstract method
    def name : String=_name
  }
//  trait FilterOutAlreadyInoculated extends Animal {
//    abstract override def giveInoculation(): Unit = // 1
//      if (!alreadyInoculated())
//        super.giveInoculation()
//  }
  class Horse(rating: Int, var inoculated: Boolean = false) extends Animal(rating,_name = "Horse") with Walks  {
    override def giveInoculation(): Unit = {
      println(name + " Getting inoculated")
      inoculated = true
    }
    override def compare(that: Animal): Int = rating - that.rating
    override def alreadyInoculated(): Boolean = inoculated
  }

  class Donkey(rating: Int, var inoculated: Boolean = false)
    extends Animal(rating,_name = "Donkey") with Walks with GoodsMover  {
    override def giveInoculation(): Unit = {
      println(name + " Getting inoculated")
      inoculated = true
    }
    override def compare(that: Animal): Int = rating - that.rating
    override def alreadyInoculated(): Boolean = inoculated
  }




}
