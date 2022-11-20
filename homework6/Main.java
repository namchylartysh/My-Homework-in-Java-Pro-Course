package homework6;

/**
 * Java Professional Homework #6
 *
 * @author Artysh
 * @version 17.11 - 21.11
 */

import lesson6.SimpleBox;

public class Main {
    public static void main(String[] args) {
        SimpleBox<Integer> a = new SimpleBox<>(2);
        SimpleBox<Integer> b = new SimpleBox<>(30);
        SimpleBox<Integer> c = new SimpleBox<>(9);
        int sum = a.getObject() + b.getObject() + c.getObject();
        System.out.println(sum);

        RubberArray<Integer> abc = new RubberArray<>();
        abc.addAll(3, 1, 18, 93);
        System.out.println(abc);
        System.out.println(abc.size());
        abc.add(-4);
        System.out.println(abc);
        abc.remove(4);
        abc.remove((Integer) 1);
        System.out.println(abc);
        System.out.println(abc.contains(4));

    }
}
