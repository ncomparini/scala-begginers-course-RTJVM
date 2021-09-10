package lectures.part2oop

object Generics extends App {
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovarianceList[+A]
  val animal: Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // animalList.add(new Dog) ?? we return a list of Animals

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  //class Car
  //val newcage = new Cage(new Car) //ERROR




}
