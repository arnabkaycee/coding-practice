public class LongestIncreasingPathMatrix {

    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        int longestIncreasingPath = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longestIncreasingPath = Math.max(longestIncreasingPath, findLongestPathFromPosition(matrix, i, j, cache, visited));
            }
        }
        return longestIncreasingPath + 1;
    }

    private boolean isNextValidPosition(int rowPos, int colPos, int dRow, int dCol, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        return dRow < rows && dCol < cols && dRow >= 0 && dCol >= 0 && matrix[dRow][dCol] > matrix[rowPos][colPos];
    }

    private int findLongestPathFromPosition(int[][] matrix, int rowPos, int colPos, int[][] cache, boolean[][] visited) {

        if (visited[rowPos][colPos]) return cache[rowPos][colPos];

        int longestPathFromPosition = 0;
        for (int[] direction : directions) {
            int dRow = rowPos + direction[0];
            int dCol = colPos + direction[1];
            if (isNextValidPosition(rowPos, colPos, dRow, dCol, matrix)) {
                longestPathFromPosition = Math.max(longestPathFromPosition, findLongestPathFromPosition(matrix, dRow, dCol, cache, visited));
                //longestPathFromPosition = 1 + longestPath;
                visited[dRow][dCol] = true;
                cache[rowPos][colPos] = longestPathFromPosition + 1;
            }
        }
        return cache[rowPos][colPos];
    }


}
