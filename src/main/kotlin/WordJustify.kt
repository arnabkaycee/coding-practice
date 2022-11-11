class WordJustify {
    fun canFitInLine(maxWidth: Int, wordBuffer: List<String>, additionalWord: String): Boolean {
        val blanksNeeded = wordBuffer.size
        return (wordBuffer.sumBy { it.length } + additionalWord.length + blanksNeeded) <= maxWidth
    }

    fun getSpacesOfLength(len: Int): String {
        val sb = StringBuilder()
        repeat(len) { sb.append(" ") }
        return sb.toString()
    }

    fun joinJustify(wordList: List<String>, maxWidth: Int, isLastLine: Boolean = false): String {
        val joinedLine = StringBuilder("")
        if (isLastLine) {
            joinedLine.append(wordList.joinToString(separator = " "))
            val remainingSpaces = maxWidth - joinedLine.length
            joinedLine.append(getSpacesOfLength(remainingSpaces))
            return joinedLine.toString()
        } else {
            val spaceCount = maxWidth - wordList.sumBy { it.length }
            var spacePerWord = 0
            var additionalSpaces = 0
            if (wordList.size > 1) {
                spacePerWord = spaceCount / wordList.lastIndex
                additionalSpaces = spaceCount % wordList.lastIndex
            } else {
                spacePerWord = spaceCount
            }
            var addedSpaces = 0
            val spaceBetweenWords = getSpacesOfLength(spacePerWord)
            for (i in 0..wordList.lastIndex) {
                joinedLine.append(wordList[i])
                if (addedSpaces < additionalSpaces) {
                    joinedLine.append(" ")
                    addedSpaces++
                }
                if (i != wordList.lastIndex || wordList.size == 1) {
                    joinedLine.append(spaceBetweenWords)
                }
            }
        }
        return joinedLine.toString()
    }

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val lines = mutableListOf<String>()
        var currLineLen = 0
        val wordBuffer = mutableListOf<String>()
        words.forEachIndexed { index, word ->

            if (canFitInLine(maxWidth, wordBuffer, word)) {
                wordBuffer.add(word)
            } else {
                lines.add(joinJustify(wordBuffer, maxWidth, false))
                wordBuffer.clear()
                wordBuffer.add(word)
            }
            if (index == words.lastIndex) {
                lines.add(joinJustify(wordBuffer, maxWidth, true))
            }
        }
        return lines
    }
}

fun main() {
    val words = listOf("What","must","be","acknowledgment","shall","be")
    WordJustify().fullJustify(words.toTypedArray(), 16).forEach { println(it) }
    val words1 = listOf("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")
    WordJustify().fullJustify(words1.toTypedArray(), 16).forEach { println(it) }
}