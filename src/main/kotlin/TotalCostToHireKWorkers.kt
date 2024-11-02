import java.util.*

class TotalCostToHireKWorkers {


    private val leftHeap = PriorityQueue<Int>(compareBy { it })
    private val rightHeap = PriorityQueue<Int>(compareBy { it })

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {

        var selectedCandidates = 0
        var totalCost = 0L
        var l: Int = 0
        var r: Int = costs.lastIndex
        while (selectedCandidates < k) {
            while (leftHeap.size < candidates && l <= r) {
                leftHeap.add(costs[l])
                ++l
            }
            while (rightHeap.size < candidates && l <= r) {
                rightHeap.add(costs[r])
                --r
            }
            val selectedCandidateCost = minIfNotEmpty(leftHeap, rightHeap).remove()
            totalCost += selectedCandidateCost
            ++selectedCandidates
        }
        return totalCost
    }

    private fun minIfNotEmpty(vararg heaps : PriorityQueue<Int>) : PriorityQueue<Int> {
        return if (heaps.all { it.isNotEmpty() }) {
            heaps.minBy { it.peek() }!!
        } else {
            heaps.single() { it.isNotEmpty() }
        }
    }

}