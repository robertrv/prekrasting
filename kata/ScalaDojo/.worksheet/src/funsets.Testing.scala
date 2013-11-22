package funsets

import scala.math.BigInt

object Testing {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Welcome to the Scala worksheet");$skip(27); 
  val list = List(1, 2, 3);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(60); 
  val stream4 = 0 #:: { println("hi"); 1 } #:: Stream.empty;System.out.println("""stream4  : scala.collection.immutable.Stream[Int] = """ + $show(stream4 ));$skip(13); val res$0 = 
  stream4(1);System.out.println("""res0: Int = """ + $show(res$0));$skip(90); 

  val numbers2 = {
    def loop(i: Int): Stream[Int] = i #:: loop(i + 1)
    loop(0)
  };System.out.println("""numbers2  : Stream[Int] = """ + $show(numbers2 ));$skip(192); 

  def loop(s: String, i: Int, iter: Iterator[Int]): Unit = {
    // Stop after 200,000
    if (i < 200001) {
      if (i % 50000 == 0) println(s + i)
      loop(s, iter.next, iter)
    }
  };System.out.println("""loop: (s: String, i: Int, iter: Iterator[Int])Unit""");$skip(30); 
  val it1 = numbers2.iterator;System.out.println("""it1  : Iterator[Int] = """ + $show(it1 ));$skip(37); 
  loop("Iterator1: ", it1.next, it1);$skip(68); 
  def naturalsFrom(i: Int): Stream[Int] = i #:: naturalsFrom(i + 1);System.out.println("""naturalsFrom: (i: Int)Stream[Int]""");$skip(60); 
  def fizz(i: Int): Stream[String] = "Fizz" #:: fizz(i + 1);System.out.println("""fizz: (i: Int)Stream[String]""");$skip(54); 
  naturalsFrom(1) zip fizz(10) take 5 foreach println;$skip(46); 
  val letters = List('a', 'b', 'c', 'd', 'e');System.out.println("""letters  : List[Char] = """ + $show(letters ));$skip(27); 
  val numbers = List(1, 2);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(22); val res$1 = 
  letters zip numbers;System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(51); val res$2 = 
  letters zip (Stream continually numbers).flatten;System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2));$skip(126); val res$3 = 
  ((Stream continually letters).flatten zip (Stream continually numbers).flatten take (letters.size max numbers.size)).toList;System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(17); val res$4 = 
  Stream.from(1);System.out.println("""res4: scala.collection.immutable.Stream[Int] = """ + $show(res$4))}



}
