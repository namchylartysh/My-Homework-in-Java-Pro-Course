package homework25;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static homework25.MainClass.START;
import static homework25.MainClass.FINISH;
import static homework25.MainClass.BARRIER;

public class Car implements Runnable {
    private static int CARS_COUNT;

    public static volatile boolean isWinnerFound = false;

    static {
        BARRIER = new CyclicBarrier(MainClass.CARS_COUNT);
        START = new CountDownLatch(MainClass.CARS_COUNT);
        FINISH = new CountDownLatch(MainClass.CARS_COUNT);
    }


    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            START.countDown();
            System.out.println(this.name + " готов");
            BARRIER.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        FINISH.countDown();
        if (isWinnerFound()) {
            System.out.println(this.name + " победил в гонке!!!");
        }
    }

    private synchronized boolean isWinnerFound() {
        if (!isWinnerFound) {
            isWinnerFound = true;
            return true;
        } else {
            return false;
        }
    }
}
