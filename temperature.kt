class Temp() {

    var celsius: Double = 0.0

    var fahrenheit: Double

    get() = (celsius*9/5)+32 //=fahrenheit

    set(value) 
    {                      
        this.celsius = (value - 32)*5/9 //=celsius
    }
}

fun main() {
    val temp = Temp()

    temp.celsius = 37.0
    println("Celsius: ${temp.celsius} = Fahrenheit: ${temp.fahrenheit}")

    temp.fahrenheit = 100.0
    println("Fahrenheit: ${temp.fahrenheit} = Celsius: ${temp.celsius}")
}