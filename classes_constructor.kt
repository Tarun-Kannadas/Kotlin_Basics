open class MyAnimal(open var name:String){
    open fun makeSound() = "Animals make sound"
    open var type:String = "type"
}

class Lion(name:String):MyAnimal(name){
    override fun makeSound() = "Lion roars"
    override var type:String = "Wild"
    var breed:String = ""
    constructor (name:String,breed:String):this(name)
    {
        this.breed = breed
    }
}

class Elephant(override var name:String):MyAnimal(name){
    override fun makeSound() = "Elephant Screams"
    override var type:String = "Nadan"
}

fun main() {
    val obj = Lion("Dexter","Wild Beast")
    val obj1 = MyAnimal("")
    val obj3 = Elephant("Velayuthan")
    println(obj1.makeSound())
    println(obj.makeSound())
    println(obj.name)
    println(obj.type)
    // println(obj.breed)
    println()
    println(obj3.makeSound())
    println(obj3.name)
    println(obj3.type)
}