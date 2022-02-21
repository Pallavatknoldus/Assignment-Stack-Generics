package com.knoldus

trait Stack[A] {
  def push(element: A): Stack[A] = new NonEmptyStack[A](element, this)
  def isEmpty: Boolean
  def top: A
  def pop: Stack[A]
}

class EmptyStack[A] extends Stack[A] {
  def isEmpty = true
  def top = throw new NullPointerException("Stack is empty")
  def pop = throw new NullPointerException("Stack is empty for pop")
}

class NonEmptyStack[A](element: A, remainingStack: Stack[A]) extends Stack[A] {
  def isEmpty = false
  def top = element
  def pop = remainingStack
}