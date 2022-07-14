package problems

/**
 * Find first & last index of a target in a sorted array
 * data type is Integer
 *
 * e.g, arr = [2, 4, 5, 5, 5, 5, 5, 7, 9]
 * target = 5
 * output: [2, 6]
 *
 * arr = [same as above]
 * target = 6
 * output = [-1, -1]
 *
 * arr = []
 * target = 8
 * o/p = [-1, -1]
 */
class FirstLastIndexNum {

    fun findFirstLastIndex(nums: IntArray, target: Int): IntArray {
        return intArrayOf(
            binarySearch(nums, target, true),
            binarySearch(nums, target, false)
        )
    }

    private fun binarySearch(nums: IntArray, target: Int, searchingLeft: Boolean): Int {
        var i = 0
        var j = nums.lastIndex
        var index = -1
        while (i <= j) {
            val mid = (i + j) / 2
            if (target == nums[mid]) {
                index = mid
                if (searchingLeft) {
                    j = mid - 1
                } else {
                    i = mid + 1
                }
            } else if (target < nums[mid]) {
                j = mid - 1
            } else {
                i = mid + 1
            }
        }
        return index
    }
}