package inversioncount

object InversionCount extends App {

  def mergeAndCountSplit(one: List[Int], two: List[Int]): (List[Int], Long) = {
    if (one.isEmpty)
      (two, 0)
    else if (two.isEmpty)
      (one, 0)
    else if (one.head < two.head) {
      val m = mergeAndCountSplit(one.tail, two)
      (one.head :: m._1, m._2)
    } else {
      val m = mergeAndCountSplit(one, two.tail)
      (two.head :: m._1, m._2 + one.size)
    }
  }

/*
  def mergeAndCountSplit(left: List[Int], right: List[Int]): (List[Int], Int) = {
    (List(), 3)
  }
*/
  def sortAndCount(ints: List[Int]): (List[Int], Long) = {
    if (ints.length == 1)
      (ints, 0)
    else {
      val (left, right) = ints.splitAt(ints.size / 2)
      val (leftSorted , i) = sortAndCount(left)
      val (rightSorted, j) = sortAndCount(right)
      val (intsSorted , k) = mergeAndCountSplit(leftSorted, rightSorted)

      (intsSorted, i + j + k)
    }
  }

  def countInversions(ints: List[Int]): Long = {
    sortAndCount(ints)._2
  }
}

// vim: set ts=4 sw=4 et:
