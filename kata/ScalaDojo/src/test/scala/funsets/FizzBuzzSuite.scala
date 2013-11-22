package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FizzBuzzSuite extends FunSuite {

  test("fizz buzz for 1"){
    assert(FizzBuzz.fizzbuzz(1) === List("1"))
  }
    
  test("fizz buzz for 3"){
    assert(FizzBuzz.fizzbuzz(3) === List("1","2", "Fizz"))
  }

  test("fizz buzz for 5"){
    assert(FizzBuzz.fizzbuzz(5) === List("1","2", "Fizz", "4", "Buzz"))
  }
  test("fizz buzz for 15"){
    assert(FizzBuzz.fizzbuzz(15) === List("1","2", "Fizz", "4", "Buzz", "Fizz", "7", "8","Fizz", "Buzz", "11","Fizz","13","14", "FizzBuzz"))
  }

}
