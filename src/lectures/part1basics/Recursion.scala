package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def aFactorialFunction(n: Int): Int = {
    if (n <= 1) 1
    else n * aFactorialFunction(n-1)
  }

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else{
      println("Computing factrial of " + n + " -  I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10)) // Stackoverflow with value of 5000

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt ): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

      factHelper(n, 1)
  }

  /*
    anotherFcatorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
    = 2 * 3 * 4 * ... * 10 * 1
  */

  //println(anotherFactorial(5000))

  def concatenateTailRec(s: String, n: Int): String = {
    @tailrec
    def concatenateHelper(i: Int, s_accumulator: String): String = {
      if (i <= 1) s_accumulator
      else concatenateHelper(i-1, s_accumulator+s)
    }
    concatenateHelper(n, s)
  }

  println(concatenateTailRec("Nadal", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUnitlTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUnitlTailRec(t-1, n % t != 0 && isStillPrime)

    isPrimeUnitlTailRec(n / 2, true)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
