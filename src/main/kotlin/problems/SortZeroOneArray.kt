package problems

object SortZeroOneArray {

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1,0)
        sortZerosOnes(arr)
        println(arr.joinToString())
    }

    private fun sortZerosOnes(arr: IntArray) {
        var l = 0
        var r = arr.lastIndex
        while (l < r) {
            if (arr[l] == 0) {
                l++
                continue
            }
            if (arr[r] == 1) {
                r--
                continue
            }
            arr[l] += arr[r]
            arr[r] = arr[l] - arr[r]
            arr[l] -= arr[r]
        }
    }
}