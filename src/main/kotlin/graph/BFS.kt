package graph

import java.util.LinkedList

private val q = LinkedList<Int>();
private val marked = mutableSetOf<Int>()
private val edgeTo = mutableMapOf<Int, Int>()
fun bfs(s: Int, g: Graph) {
    q.addLast(s)
    marked.add(s)
    while (q.isNotEmpty()) {
        val el = q.removeFirst()
        g.adjacentVertices(el).forEach {
            if (it !in marked){
                marked.add(it)
                q.addLast(it)
                edgeTo[it] = el
            }
        }
    }
}