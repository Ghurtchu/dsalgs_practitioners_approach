package foundational_components

// Vector is implemented with Trie which maintains pointers to the data in a tree structure
// Hence the performance is really good
object lists_and_vectors extends scala.App {

  val fruits: List[String] = "apple" :: "banana" :: "mango" :: Nil // immutable linked list
  // operations on head are O(1), however operations on last are O(N) and in some cases it's inefficient

  // Vector has operations of O(1) because it's implemented using Trie structure so many operations are localized within Vector.

  val vectorFruits: Vector[String] = Vector.apply("grape", "banana", "mango", "apple")
  vectorFruits(3) // apple

  val veggies: Vector[String] = Vector("cucumber", "tomato")

  val vitaminTower: Vector[String] = vectorFruits ++ veggies

  val myWords: List[String] = "dog" :: "cat" :: "rat" :: "goat" :: "cat" :: "horse" :: Nil

  println(myWords.groupBy(_.length)) // sub-lists

  println(Vector("AAA", "BB", "A", "CCC", "CC", "CCC", "BBB", "AAA").groupBy(_.length)) // sub-vectors
  println(Seq("123", "321", "32", "333", "12315", "12345", "12345").groupBy(_.length)) // sub-sequences


}
