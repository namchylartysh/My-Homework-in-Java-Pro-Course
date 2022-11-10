package homework3;

abstract public class Animal implements Actions {
    protected int distanceOfRun;
    protected int distanceOfSwim;

    public Animal(int distanceOfRun, int distanceOfSwim) {
        this.distanceOfRun = distanceOfRun;
        this.distanceOfSwim = distanceOfSwim;
    }

}
