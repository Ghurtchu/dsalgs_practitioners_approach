package foundational_components

object sliding_windows extends App {

  val nums = (0 to 9).toList

  val consecutivePairs = nums.sliding(2, 1).toList
  println(consecutivePairs)

  val consecutiveTriples = nums.sliding(3, 1).toList
  println(consecutiveTriples)

  val everySecondElement = nums.sliding(1, 2).toList
  println(everySecondElement)
    
}
