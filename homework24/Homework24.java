package homework24;

import homework4.Obstacles;

public class Homework24 {
    public static void main(String[] args) {

//        Thread green = new Thread(() -> new TrafficSignals("Green"));
//        Thread blinkingGreen = new Thread(() -> new TrafficSignals("Green"));
//        Thread yellow = new Thread(() -> new TrafficSignals("Green"));
//        Thread red = new Thread(() -> new TrafficSignals("Green"));
//        Thread redYellow = new Thread(() -> new TrafficSignals("Green"));
//
//        green.start();
//        blinkingGreen.start();
//        yellow.start();
//        red.start();
//        redYellow.start();
        new Thread(() -> new TrafficSignals("Green")).start();
        new Thread(() -> new TrafficSignals("Blinking Green")).start();
        new Thread(() -> new TrafficSignals("Yellow")).start();
        new Thread(() -> new TrafficSignals("Red")).start();
        new Thread(() -> new TrafficSignals("Red and Yellow")).start();
    }
}
