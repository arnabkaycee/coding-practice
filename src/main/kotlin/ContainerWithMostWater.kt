import kotlin.math.max
import kotlin.math.min

// 0 1 2 3 4 5 6
// arr.size = 7, i = arr.size/2 = 3, j = arr.size/2

fun maxArea(arr: IntArray): Int {

    var i = 0
    var j = arr.lastIndex
    var maxVolume = 0
    while (i < j) {
        maxVolume = max(computeVolume(i, j, arr), maxVolume)
        if (arr[i] > arr[j])
            --j
        else
            ++i
    }
    return maxVolume
}

private fun computeVolume(startIndex: Int, endIndex: Int, arr: IntArray): Int {
    return if (startIndex in arr.indices && endIndex in arr.indices) {
        val diff = endIndex - startIndex
        min(arr[startIndex], arr[endIndex]) * diff
    } else Int.MIN_VALUE
}

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
    println(maxArea(intArrayOf(4, 3, 2, 1, 4)))
}