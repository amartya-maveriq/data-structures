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
        this.leftNode?.print()
        println(this.data)
        this.rightNode?.print()
    }

    private fun TreeNode<Int>.insert(data: Int) {
        if (data >= this.data) {
            this.rightNode?.insert(data) ?: kotlin.run {
                this.rightNode = TreeNode(data)
            }
        } else {
            this.leftNode?.insert(data) ?: kotlin.run {
                this.leftNode = TreeNode(data)
            }
        }
    }
}