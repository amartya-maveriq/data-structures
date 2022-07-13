package models

data class TreeNode<T>(
    val data: T,
    var leftNode: TreeNode<T>? = null,
    var rightNode: TreeNode<T>? = null
)