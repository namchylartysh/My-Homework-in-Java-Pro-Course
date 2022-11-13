package homework4;

/**
 * Java Professional Homework #4
 *
 * @author Artysh
 * @version 10.11 - 14.11
 */

public class Main {
    public static void main(String[] args) {

        Human human = new Human(500, 3);
        Cat cat = new Cat(200, 1);
        Robot robot = new Robot(300, 2);
        Track track = new Track(500);
        Wall wall = new Wall(3);

        Actions [] subjects = {human, cat, robot};
        Obstacles [] obstacles = {track, wall};

        for (Actions subject : subjects) {
            for (Obstacles obstacle : obstacles) {
                if (obstacle == track)
                    subject.run(track.distance);
                if (obstacle == wall)
                    subject.jump(wall.height);
            }
        }
    }
}
