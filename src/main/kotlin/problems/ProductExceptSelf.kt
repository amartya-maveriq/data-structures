package problems

/**
 * Leetcode: Medium
 *
 * Given an integer array nums, return an array answer such that `answer[i]` is equal
 * to the product of all the elements of nums except `nums[i]`.

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

class ProductExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {

        // init a result array of space n => n is number of elements in the problem array
        val result = IntArray(nums.size)

        // calculate the prefix array and store in result array
        for (i in nums.indices) {
            if (i == 0) {
                result[i] = 1
                continue
            }
            result[i] = nums[i - 1] * result[i - 1]
        }

        // calculate the postfix and store in result array
        var postfix = 1
        for (i in nums.lastIndex downTo 0) {
            if (i == nums.lastIndex) {
                // it stays same because the last item has no postfix hence considered as 1
                continue
            }
            postfix *= nums[i + 1]
            result[i] *= postfix
        }

        // return result array
        return result
    }
}