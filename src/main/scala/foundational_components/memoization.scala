package foundational_components

// Memoization is a technique in which the results of previous calculations are stored
// so that they can be reused for future calculations.
object memoization {

  def factorial(x: Int): Int = {
    if (x == 0 || x == 1) 1
    else {
      println("Computing factorial...")
      x * factorial(x - 1)
    }
  }

  def main(args: Array[String]): Unit = {

    for (i <- 0 to 100) {
      val num = scala.util.Random.nextInt(10)
      println(s"computing factorial for $num")
      memoized_factorial.memoizedFactorial(num)
      println("---------------------------------")
    }
  }

  object memoized_factorial {

    var cache: Map[Int, Int] = Map()

    def lookup(num: Int): Int = cache.getOrElse(num, 0)

    def memoizedFactorial(x: Int): Int = {
      if (x == 0 || x == 1) 1
      else if (lookup(x) > 0) {
        println(s"Returning cached result for $x")
        lookup(x)
      } else {
        println(s"Performing calculation for $x")
        val factorial = x * memoizedFactorial(x - 1)
        println(s"caching: $factorial -> $x")
        cache += (x -> factorial)

        factorial
      }
    }

  }


}
