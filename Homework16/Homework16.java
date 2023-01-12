package Homework16;

/**
 * Java Professional Homework #16
 *
 * @author Artysh
 * @version 22.12 - 12.01
 */

public class Homework16 {
    public static void main(String[] args) {
        Operationable addition = (x, y) -> { return x + y; };
        Operationable substraction = (x, y) -> x - y;
        Operationable multiplication = (x, y) -> x * y;
        Operationable division = (x, y) -> x / y;

        int a = addition.calculate(5, 5);
        int b = substraction.calculate(8, 3);
        int c = multiplication.calculate(4, 4);
        int d = division.calculate(15, 5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
