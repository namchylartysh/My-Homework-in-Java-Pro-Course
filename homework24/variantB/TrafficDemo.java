package homework24.variantB;

/**
 * Java Professional Homework #24 Revised and Corrected
 *
 * @author Artysh
 * @version 6.02 - 09.02
 */

public class TrafficDemo {
    public static void main(String[] args) {

        new Thread(new TrafficSignals(Color.GREEN)).start();
        new Thread(new TrafficSignals(Color.BLINKING_GREEN)).start();
        new Thread(new TrafficSignals(Color.YELLOW)).start();
        new Thread(new TrafficSignals(Color.RED)).start();
        new Thread(new TrafficSignals(Color.RED_YELLOW)).start();
    }
}
