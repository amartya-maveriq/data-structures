package util

object Timer {

    private var timeInNanos: Long = 0

    fun start() {
        timeInNanos = System.nanoTime()
    }

    fun stop() {
        println("${(System.nanoTime()- timeInNanos)/(1000)} micros")
    }
}
