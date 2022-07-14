package ds

import models.TreeNode
import java.util.Queue

class BinaryTree<T>(
    rootData: T
) {

    val root: TreeNode<T> = TreeNode(rootData)

    /**
     * Breadth First Traversal
     */
    fun levelOrderTraverse() {
        val queue: Queue<TreeNode<T>> = java.util.LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val tempNode = queue.poll()
            println(tempNode.data.toString())
            tempNode.leftNode?.let { queue.add(it) }
            tempNode.rightNode?.let { queue.add(it) }
        }
    }

    fun levelOrderTraverse1(): List<List<T>> {
        val result = mutableListOf<List<T>>()
        val queue: Queue<TreeNode<T>> = java.util.LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val len = queue.size
            val innerList = mutableListOf<T>()
            for (i in 0 until len) {
                val tempNode = queue.poll()
                innerList.add(tempNode.data)
                tempNode.leftNode?.let { queue.add(it) }
                tempNode.rightNode?.let { queue.add(it) }
            }
            result.add(innerList)
        }
        return result
    }
}