import ds.Graph
import models.GraphNode
import problems.MaxAreaOfIsland

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = GraphNode('a')
            val b = GraphNode('b')
            val c = GraphNode('c')
            val d = GraphNode('d')
            val e = GraphNode('e')
            val f = GraphNode('f')
            val g = GraphNode('g')
            val h = GraphNode('h')
            a.neighbors.add(b.also { it.neighbors.add(c) })
            c.neighbors.add(f)
            c.neighbors.add(d.also { it.neighbors.add(e) })
            a.neighbors.add(g.also { it.neighbors.add(h) })

            Graph(listOf(a, b, c, d, e, f, g, h)).bfs()
        }
    }
}