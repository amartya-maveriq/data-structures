package algos

object BinarySearch {
    fun binarySearch(arr: IntArray, target: Int): Boolean {

        fun search(low: Int, high: Int): Boolean {
            if (low > high)
                return false
            val mid = (low + high) / 2
            return when {
                target == arr[mid] -> {
                    true
                }
                target > arr[mid] -> {
                    search(mid + 1, high)
                }
                else -> {
                    search(low, mid - 1)
                }
            }
        }

        return search(0, arr.lastIndex)
    }

    fun binarySearchIterative(arr: IntArray, target: Int): Boolean {
        var i = 0
        var j = arr.size - 1
        var mid: Int
        while (i <= j) {
            mid = (i+j)/2
            when {
                target < arr[mid] -> j = mid - 1
                target > arr[mid] -> i = mid + 1
                else -> return true
            }
        }
        return false
    }
}
