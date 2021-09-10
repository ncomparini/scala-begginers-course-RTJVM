package lectures.part3fp

import jdk.management.cmm.SystemResourcePressureMXBean

import java.util
import scala.collection.immutable.Vector
import scala.util.Random

object Sequences extends App {
  val aSequence = Seq(1, 3, 4, 2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  println(prepended)
  println(23 +: prepended :+ 89)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(apple5.mkString(":. . .:"))

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  numbers(2) = 0
  println(numbers.mkString(" "))

  val numbersSeq: Seq[Int] = numbers // implicit conversion occurs. Very advanced topic
  println(numbersSeq)

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))

  //depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
