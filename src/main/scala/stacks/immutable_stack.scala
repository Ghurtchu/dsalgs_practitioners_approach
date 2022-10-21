package stacks

import scala.annotation.tailrec

object immutable_stack {

  sealed trait ImmutableStack[A] {
    protected def head: A
    protected def tail: ImmutableStack[A]
    def push(a: A): ImmutableStack[A]
    def pop: (A, ImmutableStack[A])
    def peek: A
  }

  object ImmutableStack {

    def apply[A](elems: A*): ImmutableStack[A] = {

      @tailrec
      def loop(elements: Seq[A], acc: ImmutableStack[A]): ImmutableStack[A] = elements match {
        case Nil => acc
        case _   => loop(elements.tail, NonEmpty(elements.head, acc))
      }

      loop(elems, Empty())
    }

    private final case class NonEmpty[A](protected val head: A, tail: ImmutableStack[A]) extends ImmutableStack[A] {
      override def push(a: A): ImmutableStack[A] = NonEmpty(a, this)
      override def pop: (A, ImmutableStack[A]) = (head, tail)
      override def peek: A = head
    }

    private final case class Empty[A]() extends ImmutableStack[A] {
      override protected def head: A = throw new NoSuchElementException("empty stack")
      override protected def tail: ImmutableStack[A] = throw new NoSuchElementException("empty stack")
      override def push(a: A): ImmutableStack[A] = NonEmpty(a, Empty())
      override def pop: (A, ImmutableStack[A]) = throw new NoSuchElementException("empty stack")
      override def peek: A = throw new NoSuchElementException("empty stack")
    }

  }

  def main(args: Array[String]): Unit = {

    val stack = ImmutableStack(1, 2, 3)
    val poppedWithNewStack = stack.pop
    val popped = poppedWithNewStack._1
    val newStack = poppedWithNewStack._2
    println(s"popped = $popped")
    println(s"new stack = $newStack")
    val updated = newStack.push(1000)
    println(updated.peek)

  }

}
