package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
   val nadal = new Person("Nadal", 23)
   println(nadal.name)

  // 2. sensible toString
  println(nadal)

  // 3. equals and hashcode implemented OOTB
  val nadal2 = new Person("Nadal", 23)
  println(nadal == nadal2)

  // 4. CCs have handy copy method
  val nadal3 = nadal.copy(age = 24)
  println(nadal3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // AKKA

  // 7. CCs have extractor patterns = CCs can be used in Pattern Matching

  case object UnitedKigndom {
    def name: String = "The UK of GB and NI"
  }


}
