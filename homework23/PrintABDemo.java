package homework23;

public class PrintABDemo {
    public static void main(String[] args) {
        PrintABC pab = new PrintABC();
        new Thread(() -> pab.printA()).start();
        new Thread(() -> pab.printB()).start();
        new Thread(() -> pab.printC()).start();
    }
}
