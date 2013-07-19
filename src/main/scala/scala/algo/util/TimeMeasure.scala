package scala.algo.util

/**
 * Created with IntelliJ IDEA.
 * User: mar
 * Date: 7/19/13
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
object TimeMeasure {

  implicit def withTime[T](f: => T) = new timeMeasuring[T](f)
  class timeMeasuring[T](f: => T){
     def time() = {
       val currentTime = System.nanoTime()
       val res = f
       val afterTime = System.nanoTime()
       println("Execution time: "+ (afterTime-currentTime)/1000000000.0 + "s" )
       res
     }
  }
}
