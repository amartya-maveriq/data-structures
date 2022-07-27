package problems

object Fibonacci {

    fun fibIterative(limit: Int): Long {
        var prePrev = 0L
        var prev = 1L
        if (limit < 0) {
            throw Exception("Not a valid input")
        }
        if (limit == 0) {
            return 0
        }
        if (limit == 1) {
            return prev
        }
        for (i in 2..limit) {
            val sum = prePrev + prev
            prePrev = prev
            prev = sum
        }
        return prev
    }

    fun fibRecursive(limit: Int): Int {
        if (limit == 0) {
            return 0
        }
        if (limit == 1) {
            return 1
        }
        if (limit < 0) {
            throw Exception("Not a valid input")
        }
        return fibRecursive(limit - 1) + fibRecursive(limit - 2)
    }

    fun fibMemoized(limit: Int): Int {
        if (limit < 0) {
            throw Exception("Not a valid input")
        }
        if (limit <= 1) {
            return limit
        }
        val memo = IntArray(limit + 1) { -1 }
        memo[0] = 0
        memo[1] = 1
        fun doFib(limit: Int): Int {
            if (memo[limit] != -1) {
                return memo[limit]
            }
            memo[limit] = doFib(limit - 2) + doFib(limit - 1)
            return memo[limit]
        }
        return doFib(limit)
    }
}