package funsets

import common._

object Cube {

  def isSafe(door: List[Int]): String = {
    if (door.exists(x => isPowerOfPrimes(x))) {
      "INSECURE"
    } else {
      "SECURE"
    }
  }

  /*
  private def isPowerOfPrimes(candidate: Int) = {
    def helper(rest:Int, divisor: Int) : Boolean = {
      if (rest == 1) true 
      else rest % divisor == 0 && helper(rest / divisor, divisor)
    }
    if (candidate == 1) false
    if (candidate == 2) true
    else List.range(2, candidate).exists(helper(candidate, _))
  }
  */
  private def isPowerOfPrimes(candidate: Int): Boolean = candidate match {
    case 1 => false
    case 2 => true
    case _ => {
      def helper(rest: Int, divisor: Int): Boolean = {
        if (rest == 1) true
        else rest % divisor == 0 && helper(rest / divisor, divisor)
      }

      List.range(2, candidate).find(_ % candidate == 0) match {
        case Some(x) => helper(candidate, x)
        case None => false
      }
    }
  }

}
