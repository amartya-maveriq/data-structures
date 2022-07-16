package problems

import kotlin.math.max

object MaxAreaOfIsland {
    private var rowLen: Int = -1
    private var colLen: Int = -1
    private val set by lazy { hashSetOf<Pair<Int, Int>>() }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        rowLen = grid.size
        colLen = grid.first().size
        var area = 0
        for (row in 0 until rowLen) {
            for (col in 0 until colLen) {
                area = max(area, dfs(row, col, grid))
            }
        }
        return area
    }

    private fun dfs(row: Int, col: Int, grid: Array<IntArray>): Int {
        if (row < 0 || row == rowLen || col < 0 || col == colLen
            || grid[row][col] == 0 || set.contains(Pair(row, col))
        ) {
            return 0
        }
        set.add(Pair(row, col))
        return (1 + dfs(row + 1, col, grid)
                + dfs(row, col + 1, grid)
                + dfs(row - 1, col, grid)
                + dfs(row, col - 1, grid)
                )
    }
}