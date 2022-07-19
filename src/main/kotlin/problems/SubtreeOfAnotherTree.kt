package problems

import models.TreeNode

/**
 * Leetcode : easy
 *
 * Given the roots of two binary trees root and subRoot, return true if
 * there is a subtree of root with the same structure and node values of
 * subRoot and false otherwise.
 * A subtree of a binary tree is a tree that consists of a node in tree
 * and all of this node's descendants. The tree could also be considered as a
 * subtree of itself.
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
object SubtreeOfAnotherTree {

    fun isSubtree(root: TreeNode<Int>?, subRoot: TreeNode<Int>?): Boolean {
        if (subRoot == null)
            return true
        if (root == null)
            return false
        // These above conditions will not happen as per constraints
        // but written just to give a holistic solution

        if (sameTree(root, subRoot))
            return true

        // in a tricky corner case maybe the `val`s are same but a subtree of the current node
        // is same as the other tree e.g, [1,1] & [1]
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun sameTree(root: TreeNode<Int>?, subRoot: TreeNode<Int>?): Boolean {
        if (root==null && subRoot==null)
            return true
        if ((root!=null && subRoot!=null) &&
            (root.data == subRoot.data))
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right)
        // if one of them is null & the other is not then clearly they're not same
        // so return false
        return false
    }
}