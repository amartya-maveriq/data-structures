package problems

import kotlin.math.max

/**
 * Leetcode : medium
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.


Example 2:

Input: nums = [1]
Output: 1


Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:

1 <= nums.length <= 10^5

-10^4 <= `nums[i]` <= 10^4
 */
class MaxSumSubArray {

    fun maxSubArray(nums: IntArray): Int {
        // keep maxSub variable as a holder for the max value so far
        var maxSub = nums.first()
        // keep curSum var as a holder for latest sum
        var curSum = 0
        for (num in nums) {
            // this is just to reject the negative values added up so far
            // because two negatives will just decrease the sum even further
            if (curSum < 0) {
                curSum = 0
            }
            curSum += num
            // maxSub is getting calculated from curSum
            maxSub = max(curSum, maxSub)
        }
        return maxSub
    }
}