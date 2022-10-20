package fundamental_algorithms

object divide_and_conquer {

  def findContSubArrayMax(data: Vector[Int]): Int = data match {
    case Vector(singleElem) => singleElem
    case _                  => {
      val (left, right) = data.splitAt(data.length / 2)
      val leftMax = findContSubArrayMax(left)
      val rightMax = findContSubArrayMax(right)
      val leftRightCrossMaxVal = leftRightCrossMax(left, right)
      List(leftMax, rightMax, leftRightCrossMaxVal).max
    }
  }

  def leftRightCrossMax(left: Vector[Int], right: Vector[Int]): Int = {
    val colLeftSums = for (i <- 1 to left.length) yield left.takeRight(i).sum
    val colRightSums = for (i <- 1 to right.length) yield right.takeRight(i).sum

    colLeftSums.max + colRightSums.max
  }

  def main(args: Array[String]): Unit = {
    val data = Vector(1, -2, 5, 6, -1, 4, 9, -3, 2, 5)

    println(findContSubArrayMax(data))
  }

}
