import ds.BinaryTree
import models.TreeNode
import problems.FirstLastIndexNum
import problems.ProductExceptSelf

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                FirstLastIndexNum()
                    .findFirstLastIndex(
                        intArrayOf(
                            2,3
                        ),
                        2
                    )
                    .joinToString()
            )
        }
    }
}