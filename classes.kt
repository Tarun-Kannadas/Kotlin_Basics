class calculator()
{
    fun calc(oper:(Int,Int)->Int,a:Int?,b:Int):Int
    {
        return oper(a?:1,b)
    }
}

fun main() 
{
        
    val add = {a:Int,b:Int -> a+b}
    val sub = {a:Int,b:Int -> a-b}
    val mul = {a:Int,b:Int -> a*b}
    val div = {a:Int,b:Int -> a/b}
    
    val calc1 = calculator()
    
    val addition = calc1.calc(add,null,6)
    val subtraction = calc1.calc(sub,7,5)
    val multiplication = calc1.calc(mul,10,2)
    val division = calc1.calc(div,10,5)
    
    println(addition)
    println(subtraction)
    println(multiplication)
    println(division)
}