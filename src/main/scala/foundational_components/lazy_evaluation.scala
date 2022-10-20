package foundational_components

import java.util.Date

// Lazy evaluation = evaluate when needed
object lazy_evaluation extends scala.App {

  import java.util.Calendar

  lazy val lazyTime: Date = {
    println("evaluating lazily")
    Calendar.getInstance.getTime
  }

  val eagerTime: Date = {
    println("evaluating eagerly")
    Calendar.getInstance.getTime
  }

  println(lazyTime)

  println(eagerTime)

  def lazyFunction(arg: () => Int): Int = arg() + 1
  def lazyByName(arg: => Int): Int = arg + 1

  println(lazyFunction(() => 5) == lazyByName(5))

}
