package problems

/**
A string can be reversed using recursion.
E.g, hello -> olleh
TC -> O(n/2) = O(n)
 */
object ReverseStringRecursion {
    fun reverse(string: String, left: Int = 0, right: Int = string.lastIndex): String {
        if (left >= right) {
            return string
        }
        val tmp = string[left]
        val sb = java.lang.StringBuilder(string).also {
            it[left] = it[right]
            it[right] = tmp
        }
        return reverse(sb.toString(), left+1, right-1)
    }
}