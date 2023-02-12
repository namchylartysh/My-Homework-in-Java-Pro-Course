package homework24.variantA;

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

public class TrafficSignals {
    private final Object lock = new Object();
    private final String[] colors = {"Green", "Blinking Green", "Yellow", "Red", "Red and Yellow"};
    private volatile String currentSignal = "Green";
    private volatile int count = 0;

    public void turnOn(String color) {
        synchronized (lock) {
            try {
                while (true) {
                    while (currentSignal != color) {
                        lock.wait();
                    }
                    System.out.println(color);
                    count = count == 2? 0 : count + 1;
                    Thread.sleep(1000);
                    currentSignal = colors[count];
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
