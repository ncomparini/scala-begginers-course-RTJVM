package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahaha")
  }

  println(funnyAnimal.getClass)

  /*
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahahaha")
    }
    val funnyAnimal = new AnonymousClasses$$anon$1
  */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hu, my name is Jim, how can I be of service?")
  }



}
