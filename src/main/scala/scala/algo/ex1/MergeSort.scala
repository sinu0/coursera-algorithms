package scala.algo.ex1

import scala.collection.mutable._
import scala.annotation.tailrec

object MergeSort {

  def countSplit(arrayA: List[Int], arrayB: List[Int]): (ListBuffer[Int], Int) = {
    @tailrec
    def countSplitAndSort(a: List[Int], b: List[Int], acc: Int, output: ListBuffer[Int]): (ListBuffer[Int], Int) = {
      (a, b) match {
        case (array, Nil) => ( {
          output.append(array: _*); output
        }, acc)
        case (Nil, array) => ( {
          output.append(array: _*); output
        }, acc + 1)
        case (hA :: tA, hB :: tB) =>
          if (hA <= hB) {
            countSplitAndSort(tA, b, acc, {
              output.append(hA); output
            })
          } else {
            countSplitAndSort(a, tB, acc + 1, {
              output.append(hB); output
            })
          }
      }
    }
    countSplitAndSort(arrayA, arrayB, 0, ListBuffer[Int]())
  }

  def sort(list: ListBuffer[Int]): (ListBuffer[Int], Int) = {
    if (list.size == 1) {
      (list.to[ListBuffer], 0)
    } else {
      val newLen = list.size / 2
      val lists = list.splitAt(newLen)
      val x = sort(lists._1)
      val y = sort(lists._2)
      val z = countSplit(x._1.toList, y._1.toList)
      return (z._1, z._2 + x._2 + y._2)
    }
  }
}
