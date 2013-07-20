package algo.ex2

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */

import scala.collection.mutable._

object QuickSort {

  def swap[T](a: ArrayBuffer[T], i: Int, j: Int) = {
    val tmp = a(j)
    a.update(j, a(i))
    a.update(i, tmp)
  }

  def partition[T](array: ArrayBuffer[T], l: Int, r: Int, f: (T, T) => Boolean): (ArrayBuffer[T], Int) = {
    val pivot = array(l)
    var i = l
    for (j <- l to r) {
      if (f(array(j), pivot)) {
        swap(array, j, i)
        i += 1
      }
    }
    swap(array, l, i - 1)
    (array, i - 1)
  }

  def sort[T](array: ArrayBuffer[T], l: Int, r: Int, f: (T, T) => Boolean): Unit = {
    if (r > l) {
      val (_, pi) = partition(array, l, r, f)
      sort(array, l, pi - 1, f)
      sort(array, pi + 1, r, f)
    }
  }

}
