package problems

/**
 * leetcode 78 : medium
 * BACKTRACKING problem
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
object Subsets {

    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()
        fun generateSubsets(index: Int) {
            res.add(ArrayList(subset))
            for (i in index until nums.size) {
                // take nums[i]
                subset.add(nums[i])
                generateSubsets(i+1)
                // don't take nums[i]
                subset.removeAt(subset.lastIndex)
            }
        }
        generateSubsets(0)
        return res
    }
}