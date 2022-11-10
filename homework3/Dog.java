package homework3;

public class Dog extends Animal {
    public Dog (int distanceOfRun, int distanceOfSwim) {
        super(distanceOfRun, distanceOfSwim);
    }

    @Override
    public void run() {
        if (distanceOfRun < 500) {
            System.out.println("Dog ran " + distanceOfRun + "m");
        } else {
            System.out.println("Cat can not run more 500 m");
        }
    }

    @Override
    public void swim() {
        if (distanceOfSwim < 10) {
            System.out.println("Dog swam " + distanceOfSwim + "m");
        } else {
            System.out.println("Dog can not swim more 10 m");
        }
    }
}
