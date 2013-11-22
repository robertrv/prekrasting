package funsets

import common._

object FizzBuzz {

  def fizzbuzzNormal(n: Int): Seq[String] = {
    (1 to n) map {
      case x if x % 5 == 0 && x % 3 == 0 => "Fizz Buzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case x => x.toString
    }
  }
  
  def fizzbuzz(n: Int): Seq[String] = {
    val nones = Stream.continually(None)
    lazy val fizzes: Stream[Option[String]] = nones.take(2) ++ Some("Fizz") #:: fizzes
    lazy val buzzes: Stream[Option[String]] = nones.take(4) ++ Some("Buzz") #:: buzzes
    lazy val numbers: Stream[String] = {
      def helper(i:Int): Stream[String] =
        i.toString #:: helper(i+1)
      helper(1)
    }

    val stream = for (((fizz, buzz), n) <- fizzes zip buzzes zip numbers) 
      yield fizz.map(_ + buzz.getOrElse("")).orElse(buzz).getOrElse(n)
      
    stream.take(n).toList
  }
}
