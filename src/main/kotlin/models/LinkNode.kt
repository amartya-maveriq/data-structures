package models

/**
 * Node for Singly Linked List
 */
data class LinkNode<T>(
    val data: T,
    var next: LinkNode<T>? = null
)