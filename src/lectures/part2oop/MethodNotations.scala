package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = -1) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nick: String): Person = new Person(s"${this.name} ($nick)", this.favoriteMovie)

    def unary_! : String = s"$name, what the heck?"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def isAlive : Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(topic: String) : String = s"${this.name} is learning $topic"
    def learnsScala : String = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception" ) // infix notation

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  // prefix notation
  val x = -1
  val y = 1.unary_-

  println(!tom)
  println(tom.unary_!)

  println(tom.isAlive)
  println(tom isAlive)

  println(tom())
  println(tom.apply())


  val nadal = new Person("Nadal", "Interstellar", 23)
  val nadalStar = nadal + "The Star"

  println(nadal.name)
  println(nadalStar.name)

  val nadalPlusOne = +nadal
  println(nadalPlusOne.age)

  println(nadalStar learns "Football")
  println(nadalStar learnsScala)

  println(nadalPlusOne(3))
  println(nadalPlusOne.apply(3))
}
