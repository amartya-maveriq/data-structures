import ds.BinarySearchTree
import problems.AnagramStrings
import problems.FirstLastIndexNum
import problems.KthLargest
import problems.TwoSum

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                BinarySearchTree(7).apply {
                    insert(3)
                    insert(9)
                    insert(6)
                    insert(5)
                    insert(1)
                    insert(8)
                    insert(4)
                    insert(6)
                    insert(10)
                    insert(2)
                    print()
                }
            )
        }
    }
}