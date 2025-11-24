// Abstract class (cannot be instantiated)
abstract class Car {

    // Abstract function (must be implemented by child classes)
    abstract fun startEngine()

    // Normal function (common for all cars)
    fun applyBrakes() {
        println("Brakes applied")
    }
}

class Tesla : Car() {
    override fun startEngine() {
        println("Tesla engine starts silently using electric power")
    }
}

class Honda : Car() {
    override fun startEngine() {
        println("Honda engine starts with petrol ignition")
    }
}

fun main() {
    val t = Tesla()
    val h = Honda()

    t.startEngine()
    h.startEngine()

    t.applyBrakes()
}
