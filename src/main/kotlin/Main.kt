import algos.BinarySearch
import ds.BinaryTree
import models.TreeNode
import problems.FirstLastIndexNum
import problems.MaxSumSubArray
import problems.ProductExceptSelf
import problems.ValidParentheses

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                FirstLastIndexNum().findFirstLastIndex(
                    intArrayOf(),
                    6
                ).joinToString()
            )
        }
    }
}