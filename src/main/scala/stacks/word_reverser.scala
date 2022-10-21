package stacks

import stacks.mutable_stack.MutableStack

import collection.mutable

object word_reverser {

  def reverse(word: String): String =  {
    val reversed: mutable.StringBuilder = new mutable.StringBuilder()
    val stack = new MutableStack[Char](word.length)
    for (char <- word) stack.push(char)
    while (!stack.isEmpty) reversed.addOne(stack.pop)

    reversed.toString
  }

  def main(args: Array[String]): Unit = {

    println {
      reverse {
        "alacs evol I" // I love scala
      }
    }

  }

}
