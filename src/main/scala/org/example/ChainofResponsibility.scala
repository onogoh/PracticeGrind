package org.example

object ChainofResponsibility extends App{
  case class Task(description: String) // 1
  abstract class FamilyMember(name: String) { // 1
    def canHandle(phrases: List[String], task: Task) = // 3
      phrases exists (task.description.toLowerCase.contains(_))
    def handleIt(task: Task) = println(s"${name} Handling: " + task.description)

  }
  case object Mom extends FamilyMember("mom")
  case object Dad extends FamilyMember("dad")
  case object Kid extends FamilyMember("kid")



  type TaskHandler = PartialFunction[Task, Unit] // 2

  val dad: TaskHandler = { // 4
    case task: Task if Dad.canHandle(List("wood", "hunt"), task) => Dad.handleIt( task)
  }

  val mom: TaskHandler = { // 5
    case task: Task if Mom.canHandle(List("sew", "cook"), task) => Mom.handleIt( task)
  }

  val kid: TaskHandler = {
    case task: Task if Kid.canHandle(List("dog", "cat"), task) => Kid.handleIt(task)
  }

  val f = dad orElse mom orElse kid // 6

  f.lift(Task("feed the cat")) // 7

  val taskList = List("sew up a shirt button",
    "Walk the Dog", "cut some firewood", "feed the cat", "hhhh")

  taskList map (Task(_)) collect  f // 8

  taskList map (Task(_)) flatMap   f.lift

}
