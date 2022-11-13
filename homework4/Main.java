package homework4;

/**
 * Java Professional Homework #4
 *
 * @author Artysh
 * @version 10.11 - 14.11
 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(200, 1);
        Human human = new Human(500, 3);
        Robot robot = new Robot(300, 2);

        Track track = new Track(400);
        Wall wall = new Wall(1);

        Actions [] subjects = {human, cat, robot};
        Actions [] obstacles = {track, wall};

        for (Actions subject : subjects) {
            
                subject.run(track.distance);
                subject.jump(wall.height);
        }
    }


}
