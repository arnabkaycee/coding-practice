import org.junit.jupiter.api.Test;
import robottracker.Robot;
import robottracker.RobotCleaner;
import robottracker.RobotImpl;

import static org.junit.jupiter.api.Assertions.*;

public class RobotCleanerTest {

    @Test
    public void testCleanRoom1() {
        int[][] roomLayout = new int[][]{
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        Robot robot = new RobotImpl(roomLayout, 1, 3);
        RobotCleaner cleaner = new RobotCleaner();
        cleaner.cleanRoom(robot);
        assertTrue(robot.isAllClean());
    }
}
