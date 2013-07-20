package algo.tests

import org.scalatest.FunSuite
import scala.collection.mutable._
import algo.util.TimeMeasure._
import algo.ex2._

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
class QuickSortTest extends FunSuite {

  test("Test of partition in quick sort. Method should change order of given array 4,2,5,3,1,9,3,1 to 1,2,3,1,3,4,5,9 ") {

    val inputList = ArrayBuffer(4, 2, 5, 3, 1, 9, 3, 1)
    val properOutput = List(1, 2, 3, 1, 3, 4, 5, 9)

    val test = QuickSort.partition(inputList, 0, inputList.size - 1, (x: Int, y: Int) => x <= y)

    assert(test._1 === properOutput)

  }

  test("Test of partition in quick sort. Method should change order of given array 9,11,2 to 2,9,11 ") {

    val inputList = ArrayBuffer(9, 11, 2)
    val properOutput = List(2, 9, 11)

    val test = QuickSort.partition(inputList, 0, inputList.size - 1, (x: Int, y: Int) => x <= y)

    assert(test._1 === properOutput)
  }

  test("Test of partition in quick sort. Method should change order of given array 9 to 9 ") {

    val inputList = ArrayBuffer(9)
    val properOutput = List(9)

    val test = QuickSort.partition(inputList, 0, inputList.size - 1, (x: Int, y: Int) => x <= y)

    assert(test._1 === properOutput)
  }

  test("Sorting test. Sorted array 1,2,3 should be unchanged") {
    val inputList: ArrayBuffer[Int] = ArrayBuffer(1, 2, 3)
    val properOutput = List(1, 2, 3)

    QuickSort.sort[Int](inputList, 0, inputList.size - 1, (x, y) => x <= y)

    assert(inputList === properOutput)
  }

  test("Sorting test. Given array 3,2,5 should be 2,3,5") {
    val inputList: ArrayBuffer[Int] = ArrayBuffer(3, 2, 5)
    val properOutput = List(2, 3, 5)

    QuickSort.sort[Int](inputList, 0, inputList.size - 1, (x, y) => x <= y)

    assert(inputList === properOutput)
  }
  test("given array 1,4,5,6,3,6,1 should be sorted as 1,1,3,4,5,6,6") {
    val input = ArrayBuffer(1, 4, 5, 6, 3, 6, 1)
    val properOutput = input.sortBy(x => x)

    QuickSort.sort[Int](input, 0, input.size - 1, (x, y) => x <= y)

    assert(input === properOutput)

  }
  test("Sorting test. Very big array should be sorted") {

    import algo.util.IO._
    val big = readFile("/home/mar/QuickSort.txt")
    val bigList = big ::: big ::: big

    val output = bigList.sortBy(x => x).time
    assert(!output.equals(bigList))
    val bigL = bigList.to[ArrayBuffer]
    QuickSort.sort[Int](bigL, 0, bigList.length - 1, (x, y) => x <= y).time

    assert(bigL === output)
  }


}
