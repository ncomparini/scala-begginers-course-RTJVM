package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 7)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // ALL SCALA FUNCTIONS ARE OBJECTS

  val concatenateStrings: (String, String) => String = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }

  val specialFunction: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = specialFunction(3)
  println(adder3(4))
  println(specialFunction(3)(4)) // curried function


}

trait MyFunction[A, B] {
  def apply(element: A): B
}
