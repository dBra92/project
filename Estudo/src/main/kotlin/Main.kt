fun main(args: Array<String>) {
    //classe Instancia Objeto
    var person: Person = Person(1992, "Dan")
    person.name
    person.wakeup()
}

class Person(val birthdate: Int, val name:String){
    fun wakeup(){

    }
}