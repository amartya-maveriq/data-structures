package models

data class GraphNode<T>(
    val data: T,
    val neighbors: MutableList<GraphNode<T>> = mutableListOf()
)
