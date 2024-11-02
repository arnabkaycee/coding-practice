import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class LetterCombinationsOnKeypadTest {

    private val l = LetterCombinationsOnKeypad()

    @Test
    fun `when empty then output is empty`() {
        assertThat(l.letterCombinations("")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `when two letter combinations are used`() {
        assertThat(l.letterCombinations("23")).containsAll(listOf("ad","ae","af","bd","be","bf","cd","ce","cf"))
    }

    @Test
    fun `when single letter combinations are used`() {
        assertThat(l.letterCombinations("2")).containsAll(listOf("a","b","c"))
    }
}