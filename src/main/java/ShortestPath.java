import java.util.*;

public class ShortestPath {
    private final class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair))
                return false;
            Pair p = (Pair) obj;
            return (p.first == this.first && p.second == this.second);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    private Set<Pair> visitedVertices = new HashSet<>();
    private Queue<Pair> q = new LinkedList<>();

//    public int shortestPath(int[][] grid, int k) {
//        Pair startingPosition = new Pair(0, 0);
//        Pair target = new Pair(grid.length - 1, grid[0].length - 1);
//        int minDistance = 0;
//        q.add(startingPosition);
//        visitedVertices.add(startingPosition);
//        while (!q.isEmpty()) {
//            Pair position = q.poll();
//            List<Pair> adjacentCells = adjacentCells(grid, position.first, position.second);
//            Iterator<Pair> adjacentCellsIterator = adjacentCells.iterator();
//            while (adjacentCellsIterator.hasNext()) {
//                Pair cell = adjacentCellsIterator.next();
//                if (!visitedVertices.contains(cell)) {
//                    if (cell.equals(target)) {
//                        break;
//                    }
//                    visitedVertices.add(cell);
//                    q.add(cell);
//                }
//            }
//        }
//    }

    private List<Pair> adjacentCells(int[][] grid, int row, int col) {
        // top, left, right, down
        int rowLastIndex = grid.length - 1;
        int colLastIndex = grid[0].length - 1; // assuming it is a grid
        if (row > rowLastIndex || col > colLastIndex)
            throw new IllegalArgumentException("Invalid indices");

        List<Pair> adjacentCells = new ArrayList<>();
        // top
        if (row - 1 <= rowLastIndex && grid[row - 1][col] != 1) {
            adjacentCells.add(new Pair(row - 1, col));
        }
        // right
        if (col + 1 < colLastIndex && grid[row][col + 1] != 1) {
            adjacentCells.add(new Pair(row, col + 1));
        }
        // left
        if (col - 1 < colLastIndex && grid[row][col - 1] != 1) {
            adjacentCells.add(new Pair(row, col - 1));
        }
        // down
        if (row + 1 <= rowLastIndex && grid[row + 1][col] != 1) {
            adjacentCells.add(new Pair(row + 1, col));
        }
        return adjacentCells;
    }
}
