class Message()
{
    val String.trimEdges:String get() = substring(1, length-1)

    fun process(msg:String):String
    {
        return msg.trimEdges
    }
}//extension function usage in class

fun String.edgeTrimmer():String
{
    return this.substring(1, this.length-1)
}//extension function usage in function

val String.trimEdges:String get() = substring(1, length-1)//Normal call of extension function

fun main()
{
    println("hello".trimEdges)
    val msgprocess = Message()
    println(msgprocess.process("Wassup"))
    println("Kotlin".edgeTrimmer())
}