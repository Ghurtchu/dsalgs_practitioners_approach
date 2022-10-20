package fundamental_algorithms

object prime_numbers {

  val primes: LazyList[Int] = 2 #:: LazyList.from(3)
    .filter { num =>
      val sqrtOfPrimes = primes.takeWhile { prime =>
        prime <= math.sqrt(num)
      }

      !sqrtOfPrimes.exists(y => num % y == 0)
    }

  def main(args: Array[String]): Unit = {
    println(primes.take(15).toList) // first 15 prime numbers
  }

}
