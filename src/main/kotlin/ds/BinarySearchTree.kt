package ds

import models.TreeNode

class BinarySearchTree(rootData: Int) {

    private val rootNode: TreeNode<Int>

    init {
        rootNode = TreeNode(rootData)
    }

    fun insert(data: Int) {
        rootNode.insert(data)
    }

    /**
     * in-order traversal
     */
    fun print() {
        rootNode.print()
    }

    private fun TreeNode<Int>.print() {
        this.left?.print()
        println(this.data)
        this.right?.print()
    }

    private fun TreeNode<Int>.insert(data: Int) {
        if (data >= this.data) {
            this.right?.insert(data) ?: kotlin.run {
                this.right = TreeNode(data)
            }
        } else {
            this.left?.insert(data) ?: kotlin.run {
                this.left = TreeNode(data)
            }
        }
    }
}