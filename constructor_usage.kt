class Person(val name: String) 
{
   	var age = 0
    
    init {
        println("Username: $name")
    }
    
    constructor(name:String,age:Int):this(name)
    {
        this.age = age
        println("Age: $age")
    }
}

fun main(args:Array<String>)
{
    for (arg in args)
    {
        if (arg.isEmpty())
        {
            println("Enter Valid Argument")
            break
        }

        println("___User Details___")

        val name = args[0]
        val age = args[1].toInt()

        Person(name,age)
        break
    }
}