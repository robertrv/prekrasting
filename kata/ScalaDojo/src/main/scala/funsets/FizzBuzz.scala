package funsets

import common._

object FizzBuzz {

  def fizzbuzz(n: Int): Seq[String] = {
    (1 to n) map { 
      case x if x % 5 == 0 && x % 3 == 0 => "Fizz Buzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case x => x.toString
    }
  }
}
