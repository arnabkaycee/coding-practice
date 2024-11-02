package graph

import java.util.*

class Graph(val v: Int, directed: Boolean, private val vertexPairList: List<Pair<Int, Int>>) {

    private val graph = mutableMapOf<Int, LinkedList<Int>>()
    init {
        vertexPairList.forEach { (s, v) ->
            addEdge(s, v)
        }
    }

    private val undirected = !directed

//    val vertices : List<Int> get() = allVertices.toList()

    var e: Int = 0
        private set


    val vertices = graph.keys.toList()
//    private val allVertices = mutableSetOf<Int>()

    private fun addEdge(sourceVertex: Int, destinationVertex: Int) {
        graph.putIfAbsent(sourceVertex, LinkedList())
        val srcAdjList = checkNotNull(graph[sourceVertex])
        if (destinationVertex !in srcAdjList) {
            srcAdjList.add(destinationVertex)
        }
        if (undirected) {
            graph.putIfAbsent(destinationVertex, LinkedList())
            val destAdjList = checkNotNull(graph[destinationVertex])
            if (sourceVertex !in destAdjList) {
                destAdjList.add(sourceVertex)
            }

        }
        ++e
    }

    fun hasEdge(fromVertex: Int, toVertex: Int): Boolean {
        return toVertex in (graph[fromVertex] ?: emptyList<Int>())
    }

    fun adjacentVertices(s: Int): List<Int> {
        return graph[s]?.toList()?: emptyList()
    }

    override fun toString(): String {
        return graph.toString()
    }
}