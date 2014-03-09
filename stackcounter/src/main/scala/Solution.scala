package main.scala

object Solution {

  def solution(s: String): Int = {
    val processed = process(s.toList map {_.toString}, 0)
    if (processed.isEmpty) -1
    else processed(0).toInt
  }

  private def doOp(a: String, b: String, op: String): String =
    (op match {
      case "+" => a.toInt + b.toInt
      case "*" => a.toInt * b.toInt
    }).toString

  private def process(stack: List[String], idx: Int): List[String] = {
    if (idx >= stack.length)
      stack
    else {
      if (stack(idx) != "+" && stack(idx) != "*") {
        process(stack, idx + 1)
      } else {
        // Optimization: do this "in-place" but kills immutability
        val startStack  = stack.take(idx - 2)
        val middleStack = List(doOp(stack(idx - 2), stack(idx - 1), stack(idx)))
        val endStack    = stack.takeRight(stack.length - idx - 1)
        val newStack    = startStack ::: middleStack ::: endStack
        val newIdx = idx - 1
        process(newStack, newIdx)
      }
    }
  }

}
