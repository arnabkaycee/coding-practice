import kotlin.math.min

class MinCostOfClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val costMap = mutableMapOf<Int, Int>()
        val n = cost.size
        return min(minCostOfClimbing3(costMap, cost, n - 1), minCostOfClimbing3(costMap, cost, n - 2))
    }

    fun minCostOfClimbing3(costMap: MutableMap<Int, Int>, cost: IntArray, n: Int): Int {
        if (n < 0) return 0
        if (costMap.containsKey(n)) return costMap[n]!!
        if (n <= 1) {
            return costMap.getOrPut(n) {
                cost[n]
            }
        }
        return costMap.getOrPut(n) {
            min(
                minCostOfClimbing3(costMap, cost, n - 1),
                minCostOfClimbing3(costMap, cost, n - 2)
            ) + cost[n]
        }
    }


    fun minCostOfClimbing2(costMap: MutableMap<Int, Int>, cost: IntArray, i: Int, n: Int, c: Int): Int {
        if (i >= n) return c
        return if (i + 1 <= cost.lastIndex && i + 2 <= cost.lastIndex)
            min(
                minCostOfClimbing2(costMap, cost, i + 1, n, c + cost[i + 1]),
                minCostOfClimbing2(costMap, cost, i + 2, n, c + cost[i + 2])
            )
        else c
    }

    fun minCostOfClimbing(costMap: MutableMap<Int, Int>, cost: IntArray, i: Int, n: Int, c: Int): Int {
        if (i >= n) return c
        if (costMap[i] != null) return costMap[i]!!
        else {
            val retVal = if (i + 1 <= cost.lastIndex && i + 2 <= cost.lastIndex)
                return min(
                    minCostOfClimbing(costMap, cost, i + 1, n, c + cost[i + 1]),
                    minCostOfClimbing(costMap, cost, i + 2, n, c + cost[i + 2])
                )
            else c
            costMap[i] = retVal
            return retVal
        }
    }

    fun rob(nums: IntArray): Int {
        val profitMap = mutableMapOf<Int, Int>()
        profitMap[nums.size] = 0
        profitMap[nums.lastIndex] = nums[nums.lastIndex]
        val n = nums.lastIndex
        for (i in n - 2 downTo 0) {
            profitMap[i] = kotlin.math.max(profitMap[i - 2]!! + nums[i], profitMap[i - 1]!!)
        }
        // return maxValRob(profitMap, nums, 0)
        return profitMap[0]!!
    }
}

fun main() {
//    println(MinCostOfClimbingStairs().minCostClimbingStairs(intArrayOf(10, 15, 20)))
//    println(MinCostOfClimbingStairs().minCostClimbingStairs(intArrayOf(10, 15, 20, 30, 10, 10)))
//    println(MinCostOfClimbingStairs().minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
//    println(rob(intArrayOf(1,2,3)))
//    println(deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
//    println(deleteAndEarn(intArrayOf(3, 4, 2)))
//    println(deleteAndEarn(intArrayOf(12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93)))
//    println(deleteAndEarn(intArrayOf(2, 2, 2, 2, 2, 2, 3)))
}


fun rob(nums: IntArray): Int {
    val profits = IntArray(nums.size + 2)
    profits.fill(0)
    profits[nums.lastIndex] = nums[nums.lastIndex]
    val n = nums.size
    for (i in n - 1 downTo 1) {
        profits[i] = kotlin.math.max(profits[i + 2] + nums[i], profits[i + 1])
    }
    val t1 = profits[1]
    profits.fill(0)
    profits[nums.size - 1] = 0
    profits[nums.lastIndex - 1] = nums[nums.lastIndex - 1]
    for (i in n - 2 downTo 0) {
        profits[i] = kotlin.math.max(profits[i + 2] + nums[i], profits[i + 1])
    }
    return kotlin.math.max(profits[0], t1)
}

private fun computePoints(map: MutableMap<Int, Int>, key: Int) {
    if (map.containsKey(key)) {
        map[key] = map[key]!! + key
    } else {
        map[key] = key
    }

}

//fun deleteAndEarn(nums: IntArray): Int {
//    val omap = mutableMapOf<Int, Int>()
//    val cache = mutableMapOf<Int, Int>()
//    nums.forEach {
//        computePoints(omap, it)
//    }
//    val k = omap.maxBy { (k, v) ->
//        v
//    }
//    return delete(k!!.key, omap, cache)
//
//}

private fun deleteEntry(omap: MutableMap<Int, Int>, vararg keys: Int): MutableMap<Int, Int> {
    val temp = omap.toMutableMap()
    keys.forEach { temp.remove(it) }
    return temp
}

//fun delete(num: Int, omap: MutableMap<Int, Int>, cache: MutableMap<Int, Int>): Int {
//
//    if (omap.isEmpty()) return 0
//    if (omap.size == 1) {
//        val key = omap.keys.single()
//        return omap[key]!!
//    }
//    if (cache.containsKey(omap.keys)) return cache[omap.keys]!!
//    var max = 0
//    omap.forEach { (k, v) ->
//        val newMap = deleteEntry(omap, k, k + 1, k - 1)
//        val earnings = v * k
//        val k = delete(newMap, cache) + earnings
//        max = if (k > max) k else max
//    }
//    return max
//}

