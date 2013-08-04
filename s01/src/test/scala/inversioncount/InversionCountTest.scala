package inversioncount

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import inversioncount._

@RunWith(classOf[JUnitRunner])
class MyTests extends FunSuite {

/*
Read 100000 lines
2407905288
*/

  test("countInversions") {
    println("Start")
    val lines = scala.io.Source.fromFile("src/main/resources/IntegerArray.txt").getLines.toList.map(_.toInt)
    println("Read " + lines.length + " lines")
    println(InversionCount.countInversions(lines))
  }

  test("sortAndCount") {
    val ints = List(5, 6, 7, 8, 1, 2, 3, 4)
    assert(InversionCount.sortAndCount(ints) === (ints.sorted, 16))
  }

  test("sortAndCount 2") {
    val ints = List(3, 6, 4, 7, 8, 9, 5)
    assert(InversionCount.sortAndCount(ints) === (ints.sorted, 5))
  }

  test("mergeAndCountSplit 1") {
    val a = List(1, 2, 3, 4)
    val b = List(5, 6, 7, 8)
    assert(InversionCount.mergeAndCountSplit(a, b) === (a ::: b sorted, 0))
  }

  test("mergeAndCountSplit") {
    val a = List(1, 2, 3, 5)
    val b = List(4, 6, 7, 8)
    assert(InversionCount.mergeAndCountSplit(a, b) === (a ::: b sorted, 1))
  }
}
// vim: set ts=2 sw=2 et:
