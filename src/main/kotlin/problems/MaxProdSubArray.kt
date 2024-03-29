package problems

import java.lang.Integer.max

/**
 * Leetcode : Medium
 * https://leetcode.com/problems/maximum-product-subarray/
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
class MaxProdSubArray(
    private val nums: IntArray
) {
    fun maxProduct(): Int {
        var res = maxOfArray(nums)
        var curMax = 1
        var curMin = 1

        for (num in nums) {
            val temp = curMax
            curMax = maxOf(curMax * num, curMin * num, num)
            curMin = minOf(temp * num, curMin * num, num)
            res = max(curMax, res)
        }
        return res
    }

    private fun maxOfArray(nums: IntArray): Int {
        var temp: Int = Int.MIN_VALUE
        nums.forEach {
            if (it > temp) {
                temp = it
            }
        }
        return temp
    }
}