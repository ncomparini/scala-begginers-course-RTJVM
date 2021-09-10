package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  //println(x.length)

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43
    //case e: RuntimeException => println("caught a Runtime Exception " + e)
    //case e: NullPointerException => println("caught a Runtime Exception " + e)
  } finally {
    println("Finally!!!")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception
  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculatorException extends RuntimeException("Division by zero!")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide (x: Int, y: Int) = {
      if (y == 0) throw new MathCalculatorException
      else x / y
    }
  }

}
