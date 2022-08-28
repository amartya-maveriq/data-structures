package problems

object LongestSubstringNonRepeating {

    @JvmStatic
    fun main(args: Array<String>) {
        println(lengthOfLongestSubstring(" "))
    }

    private fun lengthOfLongestSubstring(s: String): Int {
        var maxLen = 0
        val set = hashSetOf<Char>()
        var l = 0
        var r = 0
        while (l < s.length && r < s.length) {
            if (!set.contains(s[r])) {
                set.add(s[r])
                maxLen = maxOf(maxLen, r - l + 1)
                r++
            } else {
                set.remove(s[l])
                l++
            }
        }
        return maxLen
    }
}