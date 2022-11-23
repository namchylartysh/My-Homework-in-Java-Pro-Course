package homework7;

import lesson7.RubberArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Java Professional Homework #7
 *
 * @author Artysh
 * @version 21.11 - 24.11
 */

public class Lesson {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(4, 6, 2, 9, 1));
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
        for (Integer item : numbers) {
            System.out.print(item + " ");
        }
        System.out.println();

        int[] array = {5, 7, 3, 2, 6};
        for (int item : array) {
            System.out.print(item + " ");
        }
        int i1 = 3;
        int i2 = 1;
        System.out.println();
        System.out.println(array[i1 = i2]);
        System.out.println(i1 + ", " + i2);

        System.out.println();

        RubberArray2<Integer> ra = new RubberArray2<>();
        ra.addAll(9, 3, 5, 7, 0);
//        for (Integer item : ra) {         в данном случае класс RubbyArray не поддерживает Iterator
//            System.out.print(item + " ");
//        }
        Iterator<Integer> iterator = ra.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
