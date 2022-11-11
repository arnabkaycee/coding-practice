import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LongestIncreasingPathMatrixTest {

    private static LongestIncreasingPathMatrix instance = new LongestIncreasingPathMatrix();

    @Test
    public void testBasic1() {
        int[][] input = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int output = instance.longestIncreasingPath(input);
        assertEquals(4, output);
    }

    @Test
    public void testBasic2() {
        int[][] input = new int[][] {{3,4,5},{3,2,6},{2,2,1}};
        int output = instance.longestIncreasingPath(input);
        assertEquals(4, output);
    }
}

