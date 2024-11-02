package robottracker;

public class RobotImpl implements Robot {

    private final int[][] roomLayout;

    private boolean[][] cleaned;
    private final int rows;
    private final int cols;

    private int currentRow;
    private int currentCol;

    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int currentDirection = 0;

    public RobotImpl(int[][] roomLayout, int startRow, int startCol) {
        this.roomLayout = roomLayout;
        this.rows = roomLayout.length;
        this.cols = roomLayout[0].length;
        this.currentCol = startCol;
        this.currentRow = startRow;
        this.cleaned = new boolean[rows][cols];
    }

    @Override
    public boolean move() {
        int dRow = currentRow + directions[currentDirection][0];
        int dCol = currentCol + directions[currentDirection][1];
        boolean canMove = rows > dRow && cols > dCol && dRow >= 0 && dCol >= 0 && roomLayout[dRow][dCol] != 0;
        if (canMove) {
            currentRow = dRow;
            currentCol = dCol;
        }
        return canMove;
    }

    @Override
    public void turnLeft() {
        currentDirection = (3 - currentDirection);
    }

    @Override
    public void turnRight() {
        currentDirection = (currentDirection + 1) % 4;
    }

    @Override
    public void clean() {
        cleaned[currentRow][currentCol] = true;
    }

    @Override
    public boolean isAllClean() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (roomLayout[i][j] == 1 && !cleaned[i][j])
                    return false;
            }
        }
        return true;
    }
}
