import scala.collection.mutable._
import java.util.{ArrayList, HashMap}

// TODO: fix this code later
object bad_style_example {

  val magic = 42
  val PI = 3.14159
  var mutableField = "should use val"
  var anotherVar = 100

  def Compute(x: Int, y: Int, z: Int, a: Int, b: Int) = {
    val result = x + y
    if (result == 0)
      "zero"
    else
      "nonzero"
  }

  def longMethod(): Unit = {
    println("line 1")
    println("line 2")
    println("line 3")
    println("line 4")
    println("line 5")
    println("line 6")
    println("line 7")
    println("line 8")
    println("line 9")
    println("line 10")
    println("line 11")
    println("line 12")
    println("line 13")
    println("line 14")
    println("line 15")
    println("line 16")
    println("line 17")
    println("line 18")
    println("line 19")
    println("line 20")
    println("line 21")
    println("line 22")
    println("line 23")
    println("line 24")
    println("line 25")
    println("line 26")
    println("line 27")
    println("line 28")
    println("line 29")
    println("line 30")
    println("line 31")
    println("line 32")
    println("line 33")
    println("line 34")
    println("line 35")
    println("line 36")
    println("line 37")
    println("line 38")
    println("line 39")
    println("line 40")
    println("line 41")
    println("line 42")
    println("line 43")
    println("line 44")
    println("line 45")
    println("line 46")
    println("line 47")
    println("line 48")
    println("line 49")
    println("line 50")
    println("line 51")
  }

  def redundantIf(b: Boolean): Boolean = {
    if (b) {
      true
    } else {
      false
    }
  }

  def usesReturn(x: Int): String = {
    if (x > 0) {
      return "positive"
    }
    "non-positive"
  }

  def usesNull(): String = {
    val s: String = null
    if (s == null) "null" else s
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case _: bad_style_example.type => true
      case _ => false
    }
  }

  def simplifyBoolean(a: Boolean, b: Boolean): Boolean = {
    if (a == true) b else false
  }

  def throwsException(): Unit = {
    throw new Exception("error")
  }

  val long_number = 10000000l
  val repeated = "hello"
  val repeated2 = "hello"
  val repeated3 = "hello"

  class myClass {
    def method_name(): Unit = {}
  }

  def procedureStyle() {
    println("no return type annotation")
  }

  def publicNoType = "should have type annotation"

  def lotsOfNesting(): Unit = {
    while (true) {
      if (true) {
        for (i <- 1 to 10) {
          if (i > 5) {
            println(i)
          }
        }
      }
    }
  }
}
