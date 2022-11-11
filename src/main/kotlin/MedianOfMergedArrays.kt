

fun medianOfTwoArrays(arr1: Array<Int>, arr2: Array<Int>): Double {
    val merged = mutableListOf<Int>()
    var i = 0
    var j = 0
    while (i <= arr1.lastIndex || j <= arr2.lastIndex) {
        if (i <= arr1.lastIndex && j <= arr2.lastIndex) {
            if (arr1[i] >= arr2[j]) {
                merged.add(arr2[j])
                j++
            } else {
                merged.add(arr1[i])
                i++
            }
        } else {
            if (i <= arr1.lastIndex) {
                merged.add(arr1[i])
                i++
            }
            if (j <= arr2.lastIndex) {
                merged.add(arr2[j])
                j++
            }
        }
    }
    val size = merged.size
    return if (merged.size % 2 == 0) {
        (merged[size/2] + merged[(size-1)/2]) / 2.0

    } else {
        merged[(size / 2)].toDouble()
    }
}


fun main() {
    val arr1 = intArrayOf(1,3)
    val arr2 = intArrayOf(2)

    val median = medianOfTwoArrays(arr1.toTypedArray(), arr2.toTypedArray())
    print(median)
}