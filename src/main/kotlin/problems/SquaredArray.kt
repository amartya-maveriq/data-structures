package problems

/**
 * Given two arrays arr1, arr2 of integers
 * Check if arr2 is composed of elements squared from arr1
 */
// 1, 2, 3 AND 9, 1, 4 -> true
// 1, 4, 1 AND 16, 1 -> false
// -3, 5, 3 AND 9, 9, 25 -> true
class SquaredArray(
    private val arr1: IntArray,
    private val arr2: IntArray) {

    fun isSquared(): Boolean {
        if (arr1.size != arr2.size)
            return false
        val freqCounter = hashMapOf<Int, Int>()
        arr1.forEach {
            val key = it * it
            freqCounter.putIfAbsent(key, 0)
            freqCounter[key] = freqCounter[key]!! + 1
        }
        arr2.forEach {
            freqCounter[it]?.let { counterValue ->
                if (counterValue <= 0) {
                    return false
                } else {
                    freqCounter[it] = freqCounter[it]!! - 1
                }
            } ?: return false
        }
        return true
    }
}