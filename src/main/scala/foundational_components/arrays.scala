package foundational_components

object arrays {

  def main(args: Array[String]): Unit = {

    val elements = Array(1, 2, 3, 4, 5) // same as Array.apply(elems: _*)
    val thirdElem = elements(2) // O1 operation since Array is indexed
    println(elements.apply(2)) // same as elements(2)
    println(thirdElem)

    val mappedElements = elements.map(_ * 2)
    println(mappedElements.stringify)

    println {
      multiplyByTwoImperatively {
        elements
      }.stringify
    }

    println(multiplyByTwoWhileLoop(elements).stringify)

    assert(mappedElements sameElements multiplyByTwoImperatively(elements))
    assert(mappedElements sameElements multiplyByTwoWhileLoop(elements))

    // reversal
    println(elements.reverse.stringify)

    // combination
    println((elements ++ elements).stringify)

    val arr = Array("Banana", "Apple", "Orange")
    println(arr.sorted.stringify)

    case class Data(x: Int, y: Int)
    val data = Array(Data(1, 1), Data(2, 2), Data(3, 3), Data(1, 0), Data(2, 10))
    implicit val dataOrdering: Ordering[Data] = Ordering.fromLessThan { (d1, d2) =>
      (d1.x + d1.y) <= (d2.x + d2.y)
    }
    println(data.sorted.stringify)

    println(arr.contains("Banana"))
    println(arr.exists(b => b.toLowerCase == "banana"))
    println(arr.filter(_.toLowerCase.contains("a")).stringify)

    val evens = (1 to 100).toArray.filter(_ % 2 == 0)
    println(evens.forall(_ % 2 == 0))
    println(evens.stringify)

    println(array_processing.countsMap.stringify)

    println(array_processing.comCount)

  }

  private def multiplyByTwoImperatively(array: Array[Int]): Array[Int] = {
    val arrayLength: Int = array.length
    val newArray: Array[Int] = Array.ofDim[Int](arrayLength)
    for (i <- 0 until arrayLength) {
      newArray.update(i, array(i) * 2)
    }

    newArray
  }

  private def multiplyByTwoWhileLoop(array: Array[Int]): Array[Int] = {
    val arrayLength: Int = array.length
    val newArray: Array[Int] = new Array[Int](arrayLength)
    var i: Int = 0
    while (i < arrayLength) {
      newArray(i) = array(i) * 2
      i += 1
    }

    newArray
  }

  implicit class ArrayStringifier[A](array: Array[A]) {
    def stringify: String = array.mkString("[", ",", "]")
  }

  object array_processing {

    val data: Array[String] = Array(
      "100,google.com",
      "200,mail.yahoo.com",
      "10,facebook.com",
      "203,facebook.com",
      "1,wikipedia.org",
      "123,wikipedia.org",
      "44,wikipedia.org",
      "123,google.com"
    )

    val countsMap: Array[(String, String)] = data.map(_.split(",")).map {
      case Array(s1, s2) => s1 -> s2
    }

    val comCount: Int = countsMap.map {
      case (x, y) if y.endsWith("com") => x.toInt
      case _ => 0
    }.sum

  }



}
