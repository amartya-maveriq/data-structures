package algos

object BinarySearch {
    fun binarySearch(arr: IntArray, low: Int = 0, high: Int = arr.lastIndex, target: Int): Boolean {
        if (low > high)
            return false
        val mid = (low + high) / 2
        return when {
            target == arr[mid] -> {
                true
            }
            target > arr[mid] -> {
                binarySearch(arr, mid + 1, high, target)
            }
            else -> {
                binarySearch(arr, low, mid - 1, target)
            }
        }
    }
}