import problems.MaxProdSubArray

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                MaxProdSubArray(
                    intArrayOf(-2,0,-1)
                ).maxProduct()
            )
        }
    }
}