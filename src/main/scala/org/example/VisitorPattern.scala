package org.example

object VisitorPattern {
  abstract class Friend(name: String) { // 1
    def greet(husband: Husband): Unit
    def greet(wife: Wife): Unit
  }

  case class HusbandsFriend(name: String) extends Friend(name) { // 2
    override def greet(husband: Husband): Unit = println("Hey Buddy, " + husband.name)

    override def greet(wife: Wife): Unit = println("Hello Mrs. " + wife.name)
  }

  abstract class FamilyMember(name: String)   // 3
  case class Husband(name: String) extends FamilyMember(name)
  case class Wife(name: String) extends FamilyMember(name)

  val husband = Husband("Ritesh")
  val wife = Wife("Nita")
  val husbandsFriend = HusbandsFriend("Prakash")

  def greetEachOther(familyMember: FamilyMember, friend: Friend) =
    familyMember match { // 4
    case h: Husband => friend.greet (h) // 5
    case w: Wife => friend.greet(w)
    case _ => println("Hi")
  }

  greetEachOther(husband, husbandsFriend)
  greetEachOther(wife, husbandsFriend)

}
