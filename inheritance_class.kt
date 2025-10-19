open class Animal(open var name:String){
    open fun makeSound() = "Animals make sound"
    open var type:String = "type"
}

class dog1(override var name:String):Animal(name){
    override fun makeSound() = "Dog barks"
    override var type:String = "Domestic"
}

class cat1(override var name:String):Animal(name){
    override fun makeSound() = "Cat Meows"
    override var type:String = "Nadan"
}

fun main() {
    val obj = dog1("Tiger")
    val obj1 = Animal("")
    val obj3 = cat1("Chucky")
    println(obj1.makeSound())
    println(obj.makeSound())
    println(obj.name)
    println(obj.type)
    println()
    println(obj3.makeSound())
    println(obj3.name)
    println(obj3.type)
}