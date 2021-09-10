package lectures.part1basics

object ValueVariablesTypes extends App {
  val x: Int = 14
  println(x)

  // VALS ARE IMMUTABLE
  // Vals types are optional. The compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4567
  //val aShort: Short = 45676 // Wrong larger than 2 bytes
  val aLong: Long = 345678907529L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable:Int = 4
  var anotherVariable = 167 // can also be declared without type

  aVariable = 5 // side effects

}
