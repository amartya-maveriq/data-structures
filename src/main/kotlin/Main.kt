import problems.TwoSum

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                TwoSum().twoSum(intArrayOf(3,3), 6).joinToString()
            )
        }
    }
}