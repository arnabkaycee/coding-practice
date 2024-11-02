package graph

fun main(){
    val graph = Graph(3, true, listOf(
        1 to 0,
        3 to 2,
        2 to 5
    ))
    graph.vertices.forEach {
        dfs(it, graph)
    }
    println(hasCycles)
}
private val visited = mutableSetOf<Int>()
//private var count = 0
private var hasCycles = false
//private val list = LinkedList<Int>()

private fun dfs(v: Int, graph: Graph) {
    visited.add(v)
    graph.adjacentVertices(v).forEach {
        if (it !in visited)
            dfs(it, graph)
        else {
            hasCycles = true
            return@forEach
        }
    }
}