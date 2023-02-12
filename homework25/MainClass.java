package homework25;

/**
 * Java Professional Homework #25
 *
 * @author Artysh
 * @version 09.02 - 13.02
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

    public static final int CARS_COUNT = 4;
    static CyclicBarrier BARRIER = new CyclicBarrier(CARS_COUNT);
    static CountDownLatch START = new CountDownLatch(CARS_COUNT);
    static CountDownLatch FINISH = new CountDownLatch(CARS_COUNT);
    //private final Semaphore SEMAPHORE = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        START.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        FINISH.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
