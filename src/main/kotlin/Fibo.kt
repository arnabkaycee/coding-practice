class Fibo(val n: Int) {
    var k = IntArray(n+1)
    fun find() : Int{
        if (n == 0) return 0
        if (n == 1) return 1
        k[0] = 0
        k[1] = 1
        var i = 2
        while (i <= n) {
            k[i] = k[i-1] + k[i-2]
            i++
        }
        return k[n]
    }
}

fun main(){
    print(Fibo(3).find())
}