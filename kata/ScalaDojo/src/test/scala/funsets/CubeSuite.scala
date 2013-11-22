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
class CubeSuite extends FunSuite {

  test("1 1 1"){
    assert(Cube.isSafe(List(1,1,1)) === "SECURE")
  }

  test("2 2 2"){
    assert(Cube.isSafe(List(2,2,2)) === "INSECURE")
  }

  test("1 2 1"){
    assert(Cube.isSafe(List(1,2,1)) === "INSECURE")
  }

  test("6 6 6"){
    assert(Cube.isSafe(List(6, 6, 6)) === "SECURE")
  }
  
  test("10 1 1"){
    assert(Cube.isSafe(List(10, 1, 1)) === "SECURE")
  }
  
}