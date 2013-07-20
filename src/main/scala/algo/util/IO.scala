package algo.util

import scala.io.Source._

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
object IO {

  def readFile(path: String): List[Int] = {
    val list = fromFile(path).getLines().toList map {
      elem =>
        elem.toInt
    }
    list
  }

}
