package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class StackTest extends AnyFlatSpec {

  val stack = new EmptyStack[Int]
  val stack1: Stack[Int] = stack.push(5)
  val stack2 = new NonEmptyStack[Int](6, stack1)

  // Test cases for an Empty Stack

  "A condition" should "return true if stack is Empty" in {
    assert(stack.isEmpty)
  }

  "A condition" should " throw an exception if we pop an element from an empty stack" in {
    val error = "Stack is empty for pop"
    val thrown = intercept[NullPointerException] {
      stack.pop
    }
    assert(error == thrown.getMessage)
  }

  "A condition" should " throw an exception if we try to find top element from an empty stack" in {
    val error = "Stack is empty"
    val thrown = intercept[NullPointerException] {
      stack.top
    }
    assert(error == thrown.getMessage)
  }

  "A condition" should "push an element in an empty stack" in {
    assert(stack.push(5).top == 5)
  }

  // Test cases for a Non-Empty Stack

  "A condition" should "return false if stack is not empty" in {
    assert(!stack1.isEmpty)
  }

  "A condition" should "push an element in a non empty stack" in {
    assert(stack1.push(6).top == 6)
  }

  "A condition" should "return top element from a non empty stack" in {
    assert(stack2.top == 6)
  }

  "A condition" should "pop an element from a non empty stack" in {
    assert(stack2.pop.top == 5)
  }
}