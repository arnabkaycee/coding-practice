import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TotalCostToHireKWorkersTest {

    private val t = TotalCostToHireKWorkers()

    @Test
    fun `when selecting default workers`() {
        assertThat(t.totalCost(intArrayOf(17,12,10,2,7,2,11,20,8), 3, 4)).isEqualTo(11)
    }
    @Test
    fun `when selecting lesser workers`() {
        assertThat(t.totalCost(intArrayOf(3,2,7,7,1,2), 2, 2)).isEqualTo(3)
    }

    @Test
    fun `when selecting even lesser workers`() {
        assertThat(t.totalCost(intArrayOf(1,2,4,1), 3, 3)).isEqualTo(4)
    }
}