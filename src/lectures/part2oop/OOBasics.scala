package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Nadal", 23)
  println(person.age)

  person.greet("John")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
  counter.print
}

// CONSTRUCTOR --
class Person(name: String, val age: Int = 0) { // class parameters are NOT FIELDS
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name") // overloaded method

  // MULTIPLE CONSTRUCTORS --
  // They're a little bit impracticable because the definition of an auxiliary constructor
  // must be another constructor and that can be resolved with default parameters
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
  Novel and a Writer

  Writer: first name, surname, year
  - method fullname

  Novel: name year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel

 */

class Writer(first_name: String, surname: String, val year: Int){
  def fullname(): Unit = s"${this.first_name} ${this.surname}"
}

class Novel(name: String, year_of_release: Int, author: Writer) {
  def authorAge: Int = year_of_release - author.year
  def isWrittenBy(author: Writer): Boolean = (this.author == author)
  def copy(new_year_of_release: Int) = new Novel(this.name, new_year_of_release, this.author)
}

class Counter(val count: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(count + 1)
  }
  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment.increment(amount-1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount-1)
  }

  def print = println(this.count)
}
