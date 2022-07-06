import problems.SquaredArray

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(
                SquaredArray(
                    intArrayOf(-1, -1, -1),
                    intArrayOf(1, 1, 1)
                ).isSquared()
            )
        }
    }
}