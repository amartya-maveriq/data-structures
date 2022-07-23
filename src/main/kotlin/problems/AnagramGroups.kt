package problems

/**
 * leetcode 49 : medium
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
object AnagramGroups {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val resMap = hashMapOf<Map<Char, Int>, List<String>>()
        for (str in strs) {
            val map = hashMapOf<Char, Int>()
            for (ch in str) {
                map.putIfAbsent(ch, 0)
                map[ch] = map[ch]!! + 1
            }
            resMap.putIfAbsent(map, mutableListOf())
            (resMap[map] as MutableList<String>).add(str)
        }
        return resMap.map { it.value }
    }
}