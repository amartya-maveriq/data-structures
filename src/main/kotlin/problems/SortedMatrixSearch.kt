package problems

/**
 * Easy problem
 * -------------
 * Asked on Grab interview
 * given a sorted 2D array of integers(each array is sorted, each array is larger than the previous array)
 * and a target number, find the target number, if it is found, return true, otherwise return false
 * example:
 *  [1, 2, 3, 4]
 * [5, 11, 12, 20]
 * [31, 32, 33, 34]
 */
object SortedMatrixSearch {

    fun findTarget(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in matrix.indices) {
            if (target <= matrix[i].last()) {
                return binSearch(matrix[i], target)
            }
        }
        return false
    }

    private fun binSearch(arr: IntArray, target: Int, left: Int = 0, right: Int = arr.lastIndex): Boolean {
        if (left > right) {
            return false
        }
        val mid = (left + right) / 2
        return when {
            target == arr[mid] -> return true
            target < arr[mid] -> binSearch(arr, target, left, mid-1)
            else -> binSearch(arr, target, mid+1, right)
        }
    }
}