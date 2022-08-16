package org.example

object SealedTraits extends App{
  sealed trait WeekDay
  sealed trait Month
  case object Sun extends WeekDay
  case object Mon extends WeekDay
  case object Tue extends WeekDay
  case object Wed extends WeekDay
  case object Thu extends WeekDay
  case object Fri extends WeekDay
  case object Sat extends WeekDay
  case object Jan extends Month
  def m(p: WeekDay) = println(p)

  m(Sat)
  sealed case class WeekDayOfMonth( dayOfWeek: WeekDay,
                                    month: Month)

  WeekDayOfMonth(Sun,Jan)
  sealed trait Error
  case object NotFound extends Error
  case object Unauthorized extends Error
  case object BadRequest extends Error
  case object InternalError extends Error
  case class Ko(error: Error, description: String) extends Error

}
