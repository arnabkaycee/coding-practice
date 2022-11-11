class Tribo(val n: Int) {
    var k = IntArray(n+1)
    fun find() : Int{
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return 1
        k[0] = 0
        k[1] = 1
        k[2] = 1
        var i = 3
        while (i <= n) {
            k[i] = k[i-1] + k[i-2] + k[i-3]
            i++
        }
        return k[n]
    }
}
//
//fun main(){
//    print(Tribo(25).find())
//}

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.lastIndex, target)
    }
    fun binarySearch(nums: IntArray, startIndex: Int, endIndex: Int, target: Int) : Int {
        if (startIndex > endIndex) return -1
        val size = endIndex + startIndex + 1
        val mid = size/2
        return when {
            nums[mid] == target -> mid
            target > nums[mid] -> binarySearch(nums, mid+1, endIndex, target)
            else -> binarySearch(nums, startIndex, mid - 1, target)
        }
    }
}

fun main(){
    val k = intArrayOf(-1, 0, 3, 5, 9, 12)
    println(Solution().search(k, 9))
}