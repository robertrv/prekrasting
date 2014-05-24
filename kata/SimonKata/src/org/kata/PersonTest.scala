package org.kata

class PersonTest extends org.scalatest.FunSuite {

  "A Stack" should "pop values in last-in-first-out order" in {
    val person = Person("Peter")
    person.name should be "Peter"
  }
}
