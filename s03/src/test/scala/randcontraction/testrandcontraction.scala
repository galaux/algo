package randcontraction

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import randcontraction._

class MyTests extends FunSuite {

  trait DataSet {
    val FILE_PATH = "src/test/resources/kargerMinCut.txt"

    val linesArr = scala.io.Source.fromFile(FILE_PATH).getLines.toArray
    val map = linesArr.map{
      line => (line.head, line.tail)
    }.toMap
  }

  test("Rand contraction") {
    new DataSet {
      println(map)
    }
  }
}

// vim: set ts=2 sw=2 et:
