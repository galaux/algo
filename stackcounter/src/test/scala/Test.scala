package test.scala

import org.scalatest.FunSuite

import main.scala._

class Test extends FunSuite {

  test("solution") {
    assert(9 === Solution.solution("63+"))
    assert(18 === Solution.solution("263+*"))
  }
}
