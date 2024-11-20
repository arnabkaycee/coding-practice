import kotlin.math.max

fun lengthOfLongestSubstring(str: String): Int {
    var s = 0
    var e = 0
    var l = 0
    val map = mutableMapOf<Char, Int>()
    while (e < str.length) {
        map.merge(str[e], 1, Int::plus)
        var w = e - s + 1
        when {
            map.size == w -> {
                l = max(l, w)
                ++e
            }

            else -> {
                while (map.size < w) {
                    map.merge(str[s], 1, Int::minus)
                    if (map[str[s]] == 0) map.remove(str[s])
                    s++
                    w = e - s + 1
                }
                if (map.size == w)
                    l = max(w, l)
                ++e
            }
        }
    }
    return l
}


fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}