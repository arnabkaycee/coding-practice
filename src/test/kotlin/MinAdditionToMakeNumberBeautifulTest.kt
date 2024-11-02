import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MinAdditionToMakeNumberBeautifulTest {

    private val k = MinAdditionToMakeNumberBeautiful()

    @Test
    fun test1() {
        assertThat(k.makeIntegerBeautiful(467,6)).isEqualTo(33)
    }

    @Test
    fun test2() {
        assertThat(k.makeIntegerBeautiful(16,6)).isEqualTo(4)
    }

    @Test
    fun test3() {
        assertThat(k.makeIntegerBeautiful(1,1)).isEqualTo(0)
    }
    @Test
    fun test4() {
        assertThat(k.makeIntegerBeautiful(6068060761,3)).isEqualTo(3931939239L)
    }
}