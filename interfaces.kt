interface RemoteControl {
    fun powerOn()
    fun changeChannel(channel: Int)
}

class SonyTV : RemoteControl {
    override fun powerOn() {
        println("Sony TV is ON")
    }

    override fun changeChannel(channel: Int) {
        println("Sony TV switched to channel $channel")
    }
}

class SamsungTV : RemoteControl {
    override fun powerOn() {
        println("Samsung TV is ON")
    }

    override fun changeChannel(channel: Int) {
        println("Samsung TV changed to channel $channel")
    }
}

fun main() {
    val sony = SonyTV()
    val samsung = SamsungTV()

    sony.powerOn()
    samsung.powerOn()

    sony.changeChannel(5)
    samsung.changeChannel(10)
}
