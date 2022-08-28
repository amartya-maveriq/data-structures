package problems

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
object LongestConsecutiveArray {
    fun longestConsecutive(nums: IntArray): Int {
        var maxLength = 0
        val set = nums.toHashSet()

        fun search(n: Int, len: Int = 0, greater: Boolean): Int {
            if (!set.contains(n)) {
                return len
            }
            set.remove(n)
            return if (greater) {
                search(n+1, len+1, true)
            } else {
                search(n-1, len+1, false)
            }
        }

        for (i in nums.indices) {
            if(set.contains(nums[i])) {
                maxLength = maxOf(maxLength, search(nums[i], greater=true) + search(nums[i]-1, greater=false))
            }
        }

        return maxLength
    }
}