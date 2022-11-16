package homework5;

/**
 * Java Professional Homework #5
 *
 * @author Artysh
 * @version 14.11 - 17.11
 */

import lesson5.RubberArray;

public class Main {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray();
        System.out.println(ra);
        System.out.println(ra.size());
        ra.addAll(12, 5, 3);
        // ra.add(3);
        // ra.add(5); // у меня и без скопирования старого массива выводит [12, 3, 5]
        /* System.out.println(ra);
        System.out.println(ra.size());
        System.out.println("ra[1] = " + ra.get(1));
        ra.remove(0);
        System.out.println(ra);
        ra.remove(0);
        System.out.println(ra);
        ra.remove(0); */
        System.out.println(ra);
        System.out.println(ra.contains(5));
        System.out.println(ra.contains(8));
        // ra.remove(Integer.valueOf(5));
        System.out.println(ra.remove(Integer.valueOf(5)));
    }
}
