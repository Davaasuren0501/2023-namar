public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        String[] conversation = {"Hi?", "Sain.", "Ajil ni sain uu?", "Tiim ee sain baigaa",
                "Ene chinii ajil ym uu"};

        Thread robot1Thread = new Thread(new ConversationRobot(robot, conversation));
        Thread robot2Thread = new Thread(new ConversationRobot(robot, conversation));

        robot1Thread.start();
        robot2Thread.start();

        try {
            robot1Thread.join();
            robot2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}