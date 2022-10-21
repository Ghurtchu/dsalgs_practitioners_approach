package lists

object exercise {

  def main(args: Array[String]): Unit = {

    val originalWords: List[String] = List(
      "apple", "cow", "color", "god", "goat", "dog", "house",
      "mother", "orange", "rat", "zeal", "university", "dog", "mother",
      "father", "scala"
    )

    val sortedWords = sort(originalWords)
    println(sortedWords)

    val distinctWords = removeDuplicates(sortedWords)

    val sortAndThenMakeUnique: List[String] => List[String] = sort _ andThen removeDuplicates

    println {
      sortAndThenMakeUnique {
        originalWords
      }
    }

    println {
      sortAndThenMakeUnique {
        originalWords
      }.fold("")(_ concat _)
    }

  }

  def sort(list: List[String]): List[String] = {
    implicit val ordering: Ordering[String] = _ compareTo _
    list.sorted
  }

  def removeDuplicates(list: List[String]): List[String] = list.distinct

  def totalWords(list: List[String]): Int = list.size

  def exists(word: String, list: List[String]): Boolean = list.contains(word)



}
