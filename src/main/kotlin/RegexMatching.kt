fun isMatch2(s: String, p: String): Boolean {
    return if ("*" in p || "." in p) {
        var i = 0
        var j = 0
        var matchChar: Char? = null
        var matchFlag = true
        while (i <= s.lastIndex || j <= p.lastIndex) {
            if (j <= p.lastIndex && p[j] == '*' && j == 0) {
                return false
            }
            if (i <= s.lastIndex && j <= p.lastIndex) {
                if (s[i] == p[j] || p[i] == '.') {
                    i++
                    j++
                    matchFlag = false
                    matchChar = null
                    continue
                } else if (matchFlag) {
                    if (matchChar == '.' || matchChar == s[i]) {
                        i++
                        j++
                        continue
                    } else return false
                } else if (p[j] == '*') {
                    matchChar = p[j - 1]
                    matchFlag = true
                    j++
                    i++
                    continue
                } else return false
            } else {
                if (matchChar == '.' && matchFlag)
                    return true
                return false
            }
        }
        return true
    } else {
        p == s
    }
}


fun isMatch3(s: String, p: String): Boolean {
    var i = 0
    var j = 0
    while (i <= s.lastIndex || j <= p.lastIndex) {
        if (j <= p.lastIndex && p[j] == '*' && j == 0) {
            return false
        }
        while (i <= s.lastIndex && j <= p.lastIndex) {
            if (s[i] == p[j] || p[j] == '.') {
                i++
                j++
            } else if (p[j] == '*') {
                while (i <= s.lastIndex && (s[i] == p[j - 1] || p[j - 1] == '.')) {
                    i++
                }
                j++
            } else if (j + 1 < p.lastIndex && p[j + 1] == '*') {
                if (s[i] == p[j] || p[j] == '.')
                    i++
                j += 2
            } else break
        }
        if (j <= p.lastIndex && i <= s.lastIndex && s[i] != p[j])
            return false
        if ((j > p.lastIndex || i > s.lastIndex) && j == (p.lastIndex + 1) && p[j - 1] != '*')
            return false
    }
    return true
}


fun isMatch4(s: String, p: String): Boolean {
    if ("*" !in p && "." !in p)
        return s == p

    var i = 0
    var j = 0
    var matchRoll = false
    while (i <= s.lastIndex || j <= p.lastIndex) {
        if (i <= s.lastIndex && j <= p.lastIndex) {
            if (s[i] == p[j] || p[j] == '.') {
                i++
                j++
                matchRoll = false
            } else if (p[j] == '*') {
                while (i <= s.lastIndex && (p[j - 1] == s[i] || p[j - 1] == '.'))
                    i++
                j++
                matchRoll = true
            } else if (j + 1 <= p.lastIndex && p[j + 1] == '*') {
                j += 2
            } else if (s[i] != p[j])
                return false
        } else {
            if (i > s.lastIndex && s[i - 1] != p[j])
                return false
            if (j > p.lastIndex && !matchRoll)
                return false
            return true
        }
    }
    return true
}


fun isMatch(s: String, p: String): Boolean {
    if (p == "*") return false
    if ("*" !in p && "." !in p)
        return s == p

    var i = 0
    var j = 0
    var matchRoll = false
    while (j <= p.lastIndex) {
        
        if (i <= s.lastIndex && j <= p.lastIndex) {
            if (s[i] == p[j] || p[j] == '.') {
                i++
                j++
                matchRoll = false
            } else if (p[j] == '*') {
                while (i <= s.lastIndex && (p[j - 1] == s[i] || p[j - 1] == '.'))
                    i++
                j++
                matchRoll = true
            } else if (j + 1 <= p.lastIndex && p[j + 1] == '*') {
                j += 2
            } else if (s[i] != p[j])
                return false
        } else {
            if (i > s.lastIndex && s[i - 1] != p[j])
                return false
            if (j > p.lastIndex && !matchRoll)
                return false
            return true
        }
    }
    return true
}

fun main() {
    var s = "aabb"
    var p = ".*"
    println("true," + isMatch(s, p))

    s = "aabb"
    p = "a*b*"
    println("true," + isMatch(s, p))

    s = "aabakjsdbfkajsdbfakjsdbf"
    p = "aabakjsdbfkajs.*"
    println("true," + isMatch(s, p))

    s = "asda"
    p = "af.*"
    println("false," + isMatch(s, p))

    s = "asda"
    p = "d*asda"
    println("true," + isMatch(s, p))

    s = "aa"
    p = "a"
    println("false," + isMatch(s, p))

    s = "aab"
    p = "c*a*b"
    println("true," + isMatch(s, p))

    s = "abcd"
    p = "d*"
    println("false," + isMatch(s, p))

    s = "ab"
    p = ".*c"
    println("false," + isMatch(s, p))


    s = "aaa"
    p = "a*a"
    println("true," + isMatch(s, p))


    s = "aaa"
    p = "aaaa"
    println("false," + isMatch(s, p))


    s = "aaa"
    p = "a.a"
    println("true," + isMatch(s, p))

    s = "aaa"
    p = "ab*a*c*a"
    println("true," + isMatch(s, p))
}