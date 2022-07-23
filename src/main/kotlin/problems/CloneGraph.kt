package problems

import models.GraphNode

object CloneGraph {
    private val oldNew by lazy { hashMapOf<GraphNode<Int>, GraphNode<Int>>() }

    fun cloneGraph(node: GraphNode<Int>?): GraphNode<Int>? {
        if (node == null) {
            return null
        }
        if (oldNew.containsKey(node)) {
            return oldNew[node]!!
        }
        val copy = GraphNode(node.data)
        oldNew[node] = copy
        for (neighbor in node.neighbors) {
            cloneGraph(neighbor)?.let { copy.neighbors.add(it) }
        }
        return copy
    }
}
