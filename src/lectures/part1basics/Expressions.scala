package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // DON'T USE LOOPS LIKE THIS IN SCALA
  // EVERYTHING IN SCALA IS AN EXPRESSION

  val aWeirdValue = (aVariable = 3) // Unit similar to void in other languages
  println(aWeirdValue)

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }


}
