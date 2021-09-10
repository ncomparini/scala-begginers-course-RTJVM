package lectures.part3fp

object MapFlatMapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  println(list.map(_+1))
  println(list.map(_+ " is a number"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white", "gray")


  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val combinationsColors = numbers.flatMap(n => chars.flatMap(ch => colors.map(col =>"" + n + ch + col)))
  println(combinationsColors)

  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + n + c + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  list.map {
    x => x * 2
  }
}
