package arrays

import scala.annotation.tailrec

object structure {

  def main(args: Array[String]): Unit = {

    val vowels = Array('a', 'e', 'i', 'o', 'u')
    val i = vowels(2)
    val reversed = vowels.reverse
    val size = vowels.length

    println(length(Array(1, 2, 3, 4 ,5)))
    println(length(Array()))

    val normalized = normalize(Array(
      Array(1, 2, 3),
      Array(4, 5, 6)
    ))

    val stringified = normalized.map(_.mkString("[", ",", "]")).mkString("\n")
    println(stringified)

    val a = Array(
      Array(1, 1),
      Array(1, 1)
    )

    val b = Array(
      Array(1, 1),
      Array(1, 1)
    )

    println("--------")

//    println {
//      matMult(a, b).fold("[]")(_.map(_.mkString("[", ",", "]")).mkString("\n"))
//    }

    val twoXThree = Array(
      Array(1, 2, 3),
      Array(4, 5, 6)
    )

    val threeXOne = Array(
      Array(1),
      Array(2),
      Array(3),
    )

    println {
      matMult(twoXThree, threeXOne).fold("[]")(_.map(_.mkString("[", ",", "]")).mkString("\n"))
    }

  }

  def length(array: Array[_]): Int = {

    @tailrec
    def loop(arr: Array[_], length: Int): Int = arr.headOption match {
      case Some(_) => loop(arr.tail, length + 1)
      case None    => length
    }

    loop(array, 0)
  }

  // A = [ [1, 2], [3, 4] ]
  // B = [
  //        1| 2 | 3
  //        4| 5 | 6
  //     ]
  def matMult(a: Array[Array[Int]], b: Array[Array[Int]]): Option[Array[Array[Int]]] = {
    val shapeA = shape(a)
    val shapeB = shape(b)
    if (shapeA._2 != shapeB._1) None
    else {
      val rows = shapeA._1
      val cols = shapeB._2
      val result: Array[Array[Int]] = Array.ofDim(rows, cols)
      val normalizedB = normalize(b)
      for (rowInd <- result.indices) {
        for (colInd <- result(0).indices) {
          result(rowInd)(colInd) = dot(a(rowInd), normalizedB(colInd))
        }
      }

      Some(result)
    }
  }

  def shape(arr: Array[Array[Int]]): (Int, Int) = (arr.length, arr(0).length)

  def normalize(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val indices = matrix(0).indices
    val transformed = for (i <- indices) yield {
      for (arr <- matrix) yield arr(i)
    }

    transformed.toArray
  }

  def dot(a: Array[Int], b: Array[Int]): Int = (for (i <- a.indices) yield a(i) * b(i)).sum

}
