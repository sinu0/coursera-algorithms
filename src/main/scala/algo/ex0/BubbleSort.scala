package algo.ex0

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
object BubbleSort {

  def sort[T](arrayIn: List[T], f: (T, T) => Boolean) = {


    def bubble(array: List[T]): List[T] = {
      array match {
        case h :: Nil => array
        case h :: next :: tail =>
          if (f(h, next)) {
            next :: bubble(h :: tail)
          } else {
            h :: bubble(next :: tail)
          }
      }
    }
    @tailrec
    def forLoop(arr: List[T], n: Int): List[T] = {
      if (n <= 0) return arr
      forLoop(bubble(arrayIn), n - 1)
    }
    forLoop(arrayIn, arrayIn.size * arrayIn.size * arrayIn.size + 20)
  }

}
