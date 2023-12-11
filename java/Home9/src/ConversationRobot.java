public class ConversationRobot implements Runnable {
    private Robot robot;
    private String[] conversation;

    public ConversationRobot(Robot robot, String[] conversation) {
        this.robot = robot;
        this.conversation = conversation;
    }

    @Override
    public void run() {
        for (String message : conversation) {
            if (Thread.currentThread().getId() % 2 == 0) {
                robot.speak(message);
            } else {
                robot.listen(message);
            }
        }
    }
}
