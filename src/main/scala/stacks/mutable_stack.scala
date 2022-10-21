package stacks

object mutable_stack {

  trait MutableStackProtocol[A] {
    def push(a: A): Unit
    def pop: A
    def peek: A
    def isEmpty: Boolean
    def isFull: Boolean
  }

  final class MutableStack[A](val initialSize: Int) extends MutableStackProtocol[A] {

    private var elems: Array[Any] = new Array(initialSize)
    private var index: Int = -1
    private var size: Int = initialSize

    override def push(a: A): Unit = {
      if (isFull) {
        elems = Array.copyOf(elems, elems.length * 2)
        size = elems.length * 2
      } else {
        index += 1
        elems(index) = a
      }
    }

    override def pop: A = {
      val popped: A = elems(index).asInstanceOf[A]
      index -= 1

      popped
    }

    override def peek: A = elems(index).asInstanceOf[A]

    override def isEmpty: Boolean = index == -1

    override def isFull: Boolean = index == size - 1

  }

  def main(args: Array[String]): Unit = {

    val stack = new MutableStack[Int](5)

    println(stack.isEmpty)

    for (i <- 1 to 5) {
      stack.push(i)
    }

    println(stack.isFull)

    for (i <- 6 to 10) stack.push(i)

    while (!stack.isEmpty) {
      println(stack.pop)
    }

  }

}
