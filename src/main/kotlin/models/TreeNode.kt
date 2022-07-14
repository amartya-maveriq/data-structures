package models

data class TreeNode<T>(
    val data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)