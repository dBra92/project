import sun.jvm.hotspot.oops.CellTypeState.value
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main(args: Array<String>) {
    //classe Instancia Objeto
    /*var person: Person = Person(1992, "Dan")
    person.name
    person.wakeup()
    person.doc
     */
    //Initiation("Jorge")
    // var ok = Animal("German")
    // ok.talk = "Guten tag auu"

    val a: Int = 13
    val b: Int = 31
    for (c in IntArithmetics.values()) {
        println("$c($a, $b) = ${c.apply(a, b)}")
    }
    println(Color.RED)
    EnumClass.valueOf(value: String): EnumClass
    EnumClass.values(): Array<EnumClass>
}

class Person(val birthdate: Int, var name: String) {

    var doc: String? = null

    constructor(birthdate: Int, name: String, code: Int) : this(birthdate, name) {
        this.doc = doc
    }

    fun wakeup() {}
}

class Initiation(var name: String) {
    init { // Fazer verificações de valores
        print("Ola ")
    }

    init {
        println("mundo")
    }
}

class Animal(var type: String) {
    var talk: String = ""
        get() {
            println("Acess get")
            return field
        }
        set(value) {
            field = talk
        }
}

// Enum
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// Classes anonimas
/*If the enum class defines any members, separate the constant definitions from the member definitions with a semicolon.*/
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/*An enum class can implement an interface (but it cannot derive from a class), providing either a common implementation of interface members for all the entries, or separate implementations for each entry within its anonymous class. This is done by adding the interfaces you want to implement to the enum class declaration as follows*/
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}

enum class EnumClass(value: String){

}