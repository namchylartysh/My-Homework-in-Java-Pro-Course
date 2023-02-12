package homework24.variantA;

/**
 * Java Professional Homework #24 Revised and Corrected
 *
 * @author Artysh
 * @version 6.02 - 09.02
 */

public class TrafficDemo {
    public static void main(String[] args) {
        TrafficSignals light = new TrafficSignals();
        new Thread(() -> light.turnOn("Green")).start();
        new Thread(() -> light.turnOn("Blinking Green")).start();
        new Thread(() -> light.turnOn("Yellow")).start();
        new Thread(() -> light.turnOn("Red")).start();
        new Thread(() -> light.turnOn("Red and Yellow")).start();
    }
}
