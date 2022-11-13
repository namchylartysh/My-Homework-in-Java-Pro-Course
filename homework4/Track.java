package homework4;

public class Track implements Obstacles {
    protected int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public void start() {
        System.out.println();
    }
}
