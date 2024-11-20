import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.concurrent.TimeUnit
import java.util.stream.Stream

internal class LongestSubstringWithoutRepeatingCharsKtTest {

    private companion object {
        @JvmStatic
        private fun provideStringAndExpectedValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("pwwkew", 3),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideStringAndExpectedValues")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    fun testScenarios(input: String, expected: Int) {
        assertThat(lengthOfLongestSubstring(input)).isEqualTo(expected)
    }
}