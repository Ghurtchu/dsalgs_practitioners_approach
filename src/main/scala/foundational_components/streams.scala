package foundational_components

import scala.annotation.tailrec

object streams extends scala.App {

  // scala.collection.immutable.Stream is deprecated, use LazyList instead

  val stream: LazyList[String] = "msg1" #:: "msg2" #:: "msg3" #:: LazyList.empty

  println(stream.head) // compute head only, leave others unevaluated

  println(stream.last) // compute every element and memoize results

  val str2: LazyList[String] = LazyList.cons("go", LazyList.cons("boom", LazyList.empty[String]))

  def produceInfiniteStream(current: Int): LazyList[Int] = {
    println(s"adding $current")

    LazyList.cons(current, produceInfiniteStream(current + 1))
  }

  produceInfiniteStream(0) // does not cause StackOverFlowError because the tail is unevaluated!

  // will blow up with StackOverflowError
  def produceInfiniteList(current: Int): List[Int] = {
    println(s"adding $current")
    Thread sleep 250

    current :: produceInfiniteList(current + 1)
  }

  // This is safe but it will never finish :)
  def safeInfiniteList(current: Int): List[Int] = {

    @tailrec
    def loop(start: Int, acc: List[Int]): List[Int] = {
      println(s"adding $start")
      loop(start + 1, start :: acc)
    }

    loop(current, Nil)
  }

  def safeBoundedInfiniteList(from: Int, to: Int): List[Int] = {

    @tailrec
    def loop(start: Int, end: Int, acc: List[Int]): List[Int] = {
      if (start == end) acc
      else {
        println(s"adding $start")
        loop(start + 1, end, start :: acc)
      }
    }

    loop(from, to, Nil)
  }

  safeBoundedInfiniteList(1, 500_000)

  val infStream = produceInfiniteStream(0) // from 0 to infinity
  println(infStream(1))
  println(infStream(100))
  println(infStream(999_999))

}
