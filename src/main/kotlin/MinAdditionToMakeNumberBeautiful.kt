import kotlin.math.pow

class MinAdditionToMakeNumberBeautiful {

    fun makeIntegerBeautiful(n: Long, target: Int): Long {
        var c = n
        var i = 0
        while (c.sumOfDigits() > target) {
            c = c.rollNumber(i)
            ++i
        }
        return c - n
     }

    private fun Long.rollNumber(position: Int): Long {
        val raised = 10.toDouble().pow(position).toLong()
        return ((this / raised) + 1) * raised
    }

    private fun Long.size(): Int {
        var n = this
        var l = 0
        while (n > 0) {
            n /= 10
            ++l
        }
        return l
    }

    private fun Long.sumOfDigits(): Long {
        var n = this
        var sum = 0L
        while (n>0){
            sum += (n%10)
            n/=10
        }
        return sum
    }
}