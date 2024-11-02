class LetterCombinationsOnKeypad {

    private val map : Map<Int, String> = mapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "wxyz"
    )
    fun letterCombinations(digits: String): List<String> {
        val l = digits.toCharArray().map { it.toString().toInt() }.map { map[it] }
        val o = mutableSetOf<String>()
        l.asReversed().forEach { it ->
            val op = combine(checkNotNull(it), o.toList())
            o.addAll(op)
        }
        return o.toList().filter { it.length == digits.length }
    }
    private fun combine(s1: String, s2: List<String>): List<String> {
        val o = mutableSetOf<String>()
        s1.toCharArray().forEach { t ->
            s2.forEach { it ->
                o += t + it
            }
            if (s2.isEmpty()) {
                o += t.toString()
            }
        }
        return o.toList()
    }

}