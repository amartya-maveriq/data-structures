package ds

import models.GraphNode

class Graph<T>(
    private val nodes: List<GraphNode<T>>
) {

    // used for traversing the graph
    // initialized by the root node
    private val deque by lazy { ArrayDeque<GraphNode<T>>() }

    // used for finding path between two nodes
    private val searchDeque by lazy { ArrayDeque<GraphNode<T>>() }

    init {
        kotlin.runCatching {
            check(nodes.isNotEmpty()) {
                "Nodes cannot be empty"
            }
        }.onFailure {
            println(it.message)
        }.onSuccess {
            deque.add(nodes[0])
        }
    }

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

    fun hasPath(src: GraphNode<T>, dst: GraphNode<T>): Boolean {
        searchDeque.apply {
            clear()
            add(src)
        }
        return hasPathDfsImpl(src, dst)
    }

    private fun hasPathDfsImpl(src: GraphNode<T>, dst: GraphNode<T>): Boolean {
        if (searchDeque.isEmpty())
            return false
        if (src == dst)
            return true
        val tmp = searchDeque.removeLast()
        tmp.neighbors.forEach { searchDeque.addLast(it) }
        return hasPathDfsImpl(tmp, dst)
    }
}