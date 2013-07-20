package algo.tests

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer
import algo.ex1._
import algo.util.TimeMeasure._

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */


class MergeSortTest extends FunSuite {


  lazy val sortStrategy = MergeSort

  test("given array 1,4 should be unchanged") {
    val input = List(1, 4)
    val properOutput = List(1, 4)

    val output = sortStrategy.sort(input.to[ListBuffer])

    assert(output._1 === properOutput)

  }

  test("given array 1,-1 should be sorted as -1,1") {
    val input = List(1, -1)
    val properOutput = List(-1, 1)

    val output = sortStrategy.sort(input.to[ListBuffer])

    assert(output._1 === properOutput)

  }
  test("Sorting test. Very big array should be sorted") {
    import algo.util.IO._
    val big = readFile("/home/mar/QuickSort.txt")
    val bigList = big ::: big ::: big
    val output1 = bigList.sortBy(x => x)
    val in = bigList.to[ListBuffer]
    val output = MergeSort.sort(in).time()

    assert(output._1 === output1)

  }


}
