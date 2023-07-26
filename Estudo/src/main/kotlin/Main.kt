fun main(args: Array<String>) {
    //classe Instancia Objeto
    /*var person: Person = Person(1992, "Dan")
    person.name
    person.wakeup()
    person.doc
     */
    //Initiation("Jorge")
    var ok = Animal("German")
    ok.talk = "Guten tag auu"
}

class Person(val birthdate: Int, var name: String) {

    var doc: String? = null
    constructor(birthdate: Int, name: String, code: Int) : this(birthdate, name) {
        this.doc = doc
    }
    fun wakeup() {}
}

class Initiation(var name:String){
    init { // Fazer verificações de valores
        print("Ola ")
    }
    init {
        println("mundo")
    }
}

class Animal(var type:String){
    var talk: String = ""
        get(){
            println("Acess get")
            return field
        }
        set(value){
            field = talk
        }
}