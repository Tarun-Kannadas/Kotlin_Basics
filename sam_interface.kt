fun interface calculate
{
    fun calc(a:Int,b:Int):Int
}

// val add = object:calculate
// {
//     override fun add(a: Int, b: Int): Int {
//         return a+b
//     }
// }

val add = calculate {a,b -> a+b}
val sub = calculate {a,b -> a-b}
val mul = calculate {a,b -> a*b}
val div = calculate {a,b -> a/b}

fun main()
{
    println("Addition: ${add.calc(10,20)}")
    println("Subtraction: ${sub.calc(30,18)}")
    println("Multiplication: ${mul.calc(10,20)}")
    println("Division: ${div.calc(20,10)}")
}