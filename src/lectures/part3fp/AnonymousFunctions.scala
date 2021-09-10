package lectures.part3fp

object AnonymousFunctions extends App {
  // anonymous functions (LAMBDA)
  val doubler1 = (x: Int) => x * 2
  val doubler2: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a:Int, b: Int) => a + b

  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  val specialAdder = (x: Int) => (y: Int) => x + y
  println(specialAdder(3)(4))



}
