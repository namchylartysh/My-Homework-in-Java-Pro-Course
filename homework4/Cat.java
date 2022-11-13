package homework4;

public class Cat implements Actions {
    private int runLimitOfCat;
    private int jumpLimitOfCat;
    private String type;

    public Cat(int runLimitOfCat, int jumpLimitOfCat) {
        this.runLimitOfCat = runLimitOfCat;
        this.jumpLimitOfCat = jumpLimitOfCat;
        type = "Cat";
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimitOfCat) {
            System.out.println(type + " ran successfully");
        } else {
            System.out.println(type + " failed to run");
        }
    }

    @Override
    public void jump(int height) {
        if (height <= jumpLimitOfCat) {
            System.out.println(type + " jumped over successfully");
        } else {
            System.out.println(type + " failed to jump over");
        }
    }
}
