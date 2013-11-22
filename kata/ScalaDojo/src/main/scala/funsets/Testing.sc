package funsets

import scala.math.BigInt

object Testing {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val list = List(1, 2, 3)                        //> list  : List[Int] = List(1, 2, 3)
  val stream4 = 0 #:: { println("hi"); 1 } #:: Stream.empty
                                                  //> stream4  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
  stream4(1)                                      //> hi
                                                  //| res0: Int = 1

  val numbers2 = {
    def loop(i: Int): Stream[Int] = i #:: loop(i + 1)
    loop(0)
  }                                               //> numbers2  : Stream[Int] = Stream(0, ?)

  def loop(s: String, i: Int, iter: Iterator[Int]): Unit = {
    // Stop after 200,000
    if (i < 200001) {
      if (i % 50000 == 0) println(s + i)
      loop(s, iter.next, iter)
    }
  }                                               //> loop: (s: String, i: Int, iter: Iterator[Int])Unit
  val it1 = numbers2.iterator                     //> it1  : Iterator[Int] = non-empty iterator
  loop("Iterator1: ", it1.next, it1)              //> Iterator1: 0
                                                  //| Iterator1: 50000
                                                  //| Iterator1: 100000
                                                  //| Iterator1: 150000
                                                  //| Iterator1: 200000
  def naturalsFrom(i: Int): Stream[Int] = i #:: naturalsFrom(i + 1)
                                                  //> naturalsFrom: (i: Int)Stream[Int]
  def fizz(i: Int): Stream[String] = "Fizz" #:: fizz(i + 1)
                                                  //> fizz: (i: Int)Stream[String]
  naturalsFrom(1) zip fizz(10) take 5 foreach println
                                                  //> (1,Fizz)
                                                  //| (2,Fizz)
                                                  //| (3,Fizz)
                                                  //| (4,Fizz)
                                                  //| (5,Fizz)
  val letters = List('a', 'b', 'c', 'd', 'e')     //> letters  : List[Char] = List(a, b, c, d, e)
  val numbers = List(1, 2)                        //> numbers  : List[Int] = List(1, 2)
  letters zip numbers                             //> res1: List[(Char, Int)] = List((a,1), (b,2))
  letters zip (Stream continually numbers).flatten//> res2: List[(Char, Int)] = List((a,1), (b,2), (c,1), (d,2), (e,1))
  ((Stream continually letters).flatten zip (Stream continually numbers).flatten take (letters.size max numbers.size)).toList
                                                  //> res3: List[(Char, Int)] = List((a,1), (b,2), (c,1), (d,2), (e,1))
  Stream.from(1)                                  //> res4: scala.collection.immutable.Stream[Int] = Stream(1, ?)



}