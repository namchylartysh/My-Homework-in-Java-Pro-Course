package homework4;

public class Human implements Actions {
    private int runLimitOfHuman;
    private int jumpLimitOfHuman;
    private String type;

    public Human(int runLimitOfHuman, int jumpLimitOfHuman) {
        this.runLimitOfHuman = runLimitOfHuman;
        this.jumpLimitOfHuman = jumpLimitOfHuman;
        type = "Human";
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimitOfHuman) {
            System.out.println(type + " ran successfully");
        } else {
            System.out.println(type + " failed to run");
        }
    }

    @Override
    public void jump(int height) {
        if (height <= jumpLimitOfHuman) {
            System.out.println(type + " jumped over successfully");
        } else {
            System.out.println(type + " failed to jump over");
        }
    }
}
