package problems

/**
 *
 * leetcode 347 : medium
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * Example 1:

//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:

//Input: nums = [1], k = 1
//Output: [1]
 */
object TopKFrequent {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // this array's index is number of occurrences
        val helperArray = Array<MutableList<Int>>(nums.size+1) {
            mutableListOf()
        }

        // this map will store a number in nums as key and occurrence as value
        val map = hashMapOf<Int, Int>()

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        for (entry in map.entries) {
            helperArray[entry.value].add(entry.key)
        }

        val finalArray = IntArray(k) { 0 }

        var count = 0

        for (i in helperArray.lastIndex downTo 0) {
            if (helperArray[i].isNotEmpty()) {
                for (item in helperArray[i]) {
                    finalArray[count++] = item
                    if (count == k) {
                        return finalArray
                    }
                }
            }
        }

        return finalArray
    }
}