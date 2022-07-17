package problems

/**
Leetcode: Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        // if length is not even then must be invalid
        if (s.length % 2 != 0)
            return false

        val stack = ArrayDeque<Char>()
        for (ch in s) {
            kotlin.runCatching {
                when (ch) {
                    '(', '{', '[' -> {
                        stack.addLast(ch)
                    }
                    ')' -> {
                        if (stack.removeLast() != '(') {
                            return false
                        }
                    }
                    '}' -> {
                        if (stack.removeLast() != '{') {
                            return false
                        }
                    }
                    ']' -> {
                        if (stack.removeLast() != '[') {
                            return false
                        }
                    }
                }
            }.onFailure {
                // when `stack.removeLast()` gets called but
                // there are no elements in the stack
                if (it is NoSuchElementException)
                    return false
            }
        }
        return stack.isEmpty()
    }
}