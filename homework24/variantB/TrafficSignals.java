package homework24.variantB;

import java.util.Arrays;
import java.util.List;

public class TrafficSignals implements Runnable {

    /*
        Последовательность включения сигналов светофора: зеленый (Green) -> мигающий зеленый (Blinking Green)
            -> желтый (Yellow) -> красный (Red) -> одновременно красный и желтый (Red and Yellow)


        Создается массив из строк, представляющих собой сигналы светофора.
        Создается объект lock, который будет использоваться как монитор.
        Главный принцип работы метода run() состоит из бесконечного цикла while,
            в котором присутствует некий счетчик counter, который постоянно увеличивается на 1.
        В условии цикла происходит деление счетчика на длину массива.
        Если остаток совпадает с первым индексом, то монитор захватывается и выводится значение элемента этого индекса (Green).
        Затем счетчик увеличиается на единицу.
        Если после этого остаток не совпадает с первым индексом, то монитор освобождается. Его захватывает следующий элемент
        массива, индекс которого совпадает с остатком от деления после увеличения счетчика, и выводится значение данного
        индекса (Blinking Green). И так далее.
         */
    private final int i;
    private static volatile int counter = 0;
    List<Color> lights = Arrays.asList(Color.GREEN, Color.BLINKING_GREEN, Color.YELLOW, Color.RED, Color.RED_YELLOW);

    public TrafficSignals(Color color) {
        this.i = lights.indexOf(color);
    }

    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (true) {
                    while (counter % lights.size() != i) {
                        lock.wait();
                    }
                    System.out.println(lights.get(counter % lights.size()));
                    counter++;
                    Thread.sleep(1000);
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
