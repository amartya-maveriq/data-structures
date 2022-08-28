package problems

object SearchSortedArray {

    @JvmStatic
    fun main(args: Array<String>) {
        println(search(intArrayOf(4,5,6,7,8,1,2,3), 8))
    }

    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = (l+r) / 2
            if (target == nums[mid])    return mid
            else if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
        }
        return -1
    }
}