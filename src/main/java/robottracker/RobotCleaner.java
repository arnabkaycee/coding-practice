package robottracker;

import static robottracker.RobotTracker.ROTATION.*;


public class RobotCleaner {

    private RobotTracker rt = new RobotTracker();

    private Robot robot = null;

    public void cleanRoom(Robot robot) {
        if (robot == null)
            throw new IllegalArgumentException("Robot object must be instantiated");

        this.robot = robot;
        robot.clean();
        cleanRoomDfs(robot);
    }

    private void cleanRoomDfs(Robot robot) {

        // turn left
        if (rt.canVisit(LEFT)) {
            robot.turnLeft();
            if (robot.move()) {
                robot.clean();
                rt.moveAndClean(LEFT);
                cleanRoomDfs(robot);
            } else {
                rt.cannotClean(LEFT);
            }
        }
        rt.retreat();

        // turn right
        if (rt.canVisit(RIGHT)) {
            robot.turnRight();
            if (robot.move()) {
                robot.clean();
                rt.moveAndClean(RIGHT);
                cleanRoomDfs(robot);
            } else {
                rt.cannotClean(RIGHT);
            }
        }
        rt.retreat();


        // go ahead
        if (rt.canVisit(null)){
            robot.turnRight();
            if (robot.move()) {
                robot.clean();
                rt.moveAndClean(null);
                cleanRoomDfs(robot);
            } else {
                rt.cannotClean(null);
            }
        }
        rt.retreat();

        //go back
        robot.turnRight();
        robot.turnRight();

        if (rt.canVisit(null)){
            robot.turnRight();
            if (robot.move()) {
                robot.clean();
                rt.moveAndClean(null);
                cleanRoomDfs(robot);
            } else {
                rt.cannotClean(null);
            }
        }

    }


}
