import java.util.*



fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val k = PriorityQueue<Int>(Comparator { o1:Int, o2:Int -> o1-o2 })

    if (intervals.isEmpty()) return 0

    Arrays.sort(intervals, Comparator{o1: IntArray, o2: IntArray -> o1[0] - o2[0] })
    k.add(intervals[0][1])



    for (i in 1..intervals.lastIndex) {
        if (intervals[i][0] > k.peek()){
            k.poll()
        }
        k.add(intervals[i][1])
    }

    return k.size

}

fun main() {
//    val arr = arrayOf(intArrayOf(0,30), intArrayOf(5,10), intArrayOf(15,20))
//    val arr2 = arrayOf(intArrayOf(7,10), intArrayOf(2,4))
    val arr3 = arrayOf(intArrayOf(6,15), intArrayOf(13,20), intArrayOf(6,17))
//    println(minMeetingRooms(arr))
//    println(minMeetingRooms(arr2))
    println(minMeetingRooms(arr3))
}