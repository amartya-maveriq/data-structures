package problems

import models.TreeNode

/**
 * Leetcode : medium
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal
 * of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
class BinTreeFromPreInOrder {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode<Int>? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }
        val root = TreeNode(preorder.first())
        val mid = inorder.indexOf(preorder.first())
        root.left = buildTree(
            preorder.sliceArray(1..mid),
            inorder.sliceArray(0 until mid)
        )
        root.right = buildTree(
            preorder.sliceArray((mid + 1)..preorder.lastIndex),
            inorder.sliceArray((mid + 1)..inorder.lastIndex)
        )
        return root
    }
}