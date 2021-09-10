package lectures.part2oop

object Objects {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person {
    //"static" / "class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    //def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality

  }
  // object-class with the same name: COMPANIONS

  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val bobbie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }

}
