package fundamental_algorithms

object decimal_to_binary {

  def toBin(x: Int): String = {
    val seqOfDivByTwo = Iterator.iterate(x)(_ / 2)
    val binList = seqOfDivByTwo.takeWhile(_ > 0)
    binList.mkString.reverse
  }

  def main(args: Array[String]): Unit = {
    println(toBin(5))
    println(toBin(8))
  }

}
