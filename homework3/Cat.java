package homework3;

public class Cat extends Animal {
    public Cat (int distanceOfRun, int distanceOfSwim) {
        super(distanceOfRun, distanceOfSwim);
    }

    @Override
    public void run() {
        if (distanceOfRun < 200) {
            System.out.println("Cat ran " + distanceOfRun + "m");
        } else {
            System.out.println("Cat can not run more 200 m");
        }
    }

    @Override
    public void swim() {
        System.out.println("Cat can not swim at all");
    }
}
