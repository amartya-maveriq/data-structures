package ds

import models.GraphNode

class Graph<T>(
    private val nodes: List<GraphNode<T>>
) {

    private val deque= ArrayDeque<GraphNode<T>>().also { it.add(nodes[0]) }

    fun dfs() {
        // here deque will behave like a stack
        if (deque.isEmpty())
            return
        val currentNode = deque.removeLast()
        currentNode.neighbors.forEach { deque.addLast(it) }
        println(currentNode.data.toString())
        dfs()
    }

    fun bfs(){
        // here deque will behave like a queue
        if (deque.isEmpty())
            return
        val currentNode = deque.removeFirst()
        currentNode.neighbors.forEach { deque.addLast(it) }
        println(currentNode.data.toString())
        bfs()
    }
}