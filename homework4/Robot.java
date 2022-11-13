package homework4;

public class Robot implements Actions {
    private int runLimitOfRobot;
    private int jumpLimitOfRobot;
    private String type;
    public Robot(int runLimitOfHuman, int jumpLimitOfHuman) {
        this.runLimitOfRobot = runLimitOfRobot;
        this.jumpLimitOfRobot = jumpLimitOfRobot;
        type = "Robot";
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimitOfRobot) {
            System.out.println(type + " ran successfully");
        } else {
            System.out.println(type + " failed to run");
        }
    }

    @Override
    public void jump(int height) {
        if (height <= jumpLimitOfRobot) {
            System.out.println(type + " jumped over successfully");
        } else {
            System.out.println(type + " failed to jump over");
        }
    }
}
