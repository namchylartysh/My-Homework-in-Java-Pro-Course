package homework24;

import java.util.Arrays;

public class TrafficSignals implements Runnable {
    /*
    Последовательность включения сигналов светофора: зеленый (Green) -> мигающий зеленый (Blinking Green)
        -> желтый (Yellow) -> красный (Red) -> одновременно красный и желтый (Red and Yellow)

    Принцип работы основывается на
    Создается массив из строк, представляющих собой сигналы светофора.
    Создается объект lock, который будет использоваться как монитор.
    Главный принцип работы метода run() состоит из бесконечного цикла while,
        в котором присутствует некий счетчик counter, который постоянно увеличивается на 1.
    В условии цикла происходит деление счетчика на длину массива.
    Если остаток совпадает с первым индексом, то монитор захватывается и выводится значение элемента этого индекса (Green).
    Затем счетчик увеличиается на единицу.
    Если после этого остаток не совпадает с первым индексом, то монитор освождается. Его захватывает следующий элемент
    массива, индекс которого совпадает с остатком от деления после увеличения счетчика, и выводится значение данного
    индекса (Blinking Green). И так далее.


    Проблема: не получается вывести значения в отдельных потоках

     */
    private int i;
    private static volatile int counter = 0;
    public String value;

    public String[] lights = {"Green", "Blinking Green", "Yellow", "Red", "Red and Yellow"};

    public TrafficSignals(String value) {
        this.value = value;
        for (int j = 0; j < lights.length; j++) {
            if (value.equals(lights[j])) {
                this.i = j;
            }
        }
    }

    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (true) {
                    while (counter % lights.length != i) {
                        lock.wait();
                    }
                    System.out.println(lights[counter % lights.length]);
                    counter++;
                    Thread.sleep(1000);
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(lights);
    }
}
