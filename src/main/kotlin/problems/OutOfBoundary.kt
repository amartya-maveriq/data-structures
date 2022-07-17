package problems

/**
 * Leetcode : medium
 * https://leetcode.com/problems/out-of-boundary-paths/
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 *  You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the
 * grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

* Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths
* to move the ball out of the grid boundary.
*
* Since the answer can be very large, return it modulo 109 + 7.
 */
object OutOfBoundary {

    private val memoized: Array<Array<IntArray>> by lazy {
        Array(51) {
            Array(51) {
                IntArray(51) { -1 }
            }
        }
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        return findPathsHelper(m, n, maxMove, startRow, startColumn)
    }

    private fun findPathsHelper(m: Int, n: Int, maxMove: Int, i: Int, j: Int): Int {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return 1
        }
        if (maxMove <= 0) {
            return 0
        }
        if (memoized[i][j][maxMove] != -1) {
            return memoized[i][j][maxMove]
        }
        var res = 0L
        res += findPathsHelper(m, n, maxMove - 1, i + 1, j)
        res += findPathsHelper(m, n, maxMove - 1, i, j + 1)
        res += findPathsHelper(m, n, maxMove - 1, i - 1, j)
        res += findPathsHelper(m, n, maxMove - 1, i, j - 1)
        memoized[i][j][maxMove] = (res % 1000000007).toInt()
        return memoized[i][j][maxMove]
    }
}