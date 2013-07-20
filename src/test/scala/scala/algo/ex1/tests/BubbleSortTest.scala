package scala.algo.ex1.tests

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */

import scala.algo.ex0.BubbleSort
import org.scalatest.FunSuite

class BubbleSortTest extends FunSuite {
  lazy val sortStrategy = BubbleSort

  test("given array 1 should be unchanged") {

    val inputList = List(1)
    val properList = List(1)

    val outputList = sortStrategy.sort[Int](inputList, (x, y) => x > y)

    assert(outputList.equals(properList))
  }

  test("given array 1,2 should be unchanged") {

    val inputList = List(1, 2)
    val properList = List(1, 2)

    val outputList = sortStrategy.sort[Int](inputList, (x, y) => x > y)

    assert(outputList.equals(properList))
  }
  test("given array 1,-1 should be -1,1") {


    val inputList = List(1, -1)
    val properList = List(-1, 1)

    val outputList = sortStrategy.sort[Int](inputList, (x, y) => x > y)

    assert(outputList.equals(properList))
  }
  //  test("given array 1,2,3,6,2,6,3 should be 1,2,2,3,3,6,6"){
  //
  //    import scala.algo.util.TimeMeasure._
  //
  //    val inputList = List(1,2,3,6,2,6,3)
  //    val properList = List(1,2,2,3,3,6,6)
  //
  //    val outputList = sortStrategy.sort[Int](inputList,(x,y) => x > y).time
  //    println(outputList)
  //    assert(outputList.equals(properList))
  //  }
  //  test("given array 1,2,3,6,2,6,3 should be 1,2,2,3,3,6f,6"){
  //
  //    import scala.algo.util.TimeMeasure._
  //
  //    val inputList = List(1,2,3,6,2,6,3,1,2,3,6,2,6,3,1,2,3,6,2,6,3,1,2,3,6,2,6,3,1,2,3,6,2,6,3)
  //    val properList = List(1,2,2,3,3,6,6)
  //
  //    val outputList = sortStrategy.sort[Int](inputList,(x,y) => x > y)
  //    println(outputList)
  //    assert(outputList.equals(properList))
  //  }
}
