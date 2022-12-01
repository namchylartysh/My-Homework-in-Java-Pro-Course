package homework9;

import java.util.Iterator;

/**
 * Java Professional Homework #9
 *
 * @author Artysh
 * @version 28.11 - 01.12
 */

public class HomeWork9 {
    public static void main(String[] args) {
        String str = "Hello";
        str += ", Java!";
        System.out.println(str);

        RubberList<Integer> rl = new RubberList<>();
        rl.add(3);
        rl.add(5);
        rl.remove(5);
        System.out.println(rl);
//      System.out.println(rl.getFirst() + " : " + rl.getLast());
//      rl.remove(4);
//      System.out.println(rl);
//      System.out.println(rl.getFirst() + " : " + rl.getLast());
        rl.add(10);
        System.out.println(rl);
//        System.out.println(rl.getFirst() + " : " + rl.getLast());
        rl.add(15);
        System.out.println(rl);

        System.out.println("----------------");

        RubberList<Integer> kl = new RubberList<>();
        kl.addAll(2, 6, 11, 9, 17, 1);
        System.out.println(kl);
        Iterator<Integer> iterator = kl.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value > 10) {
                iterator.remove();
            }
        }
        System.out.println(kl);

        System.out.println("------------------");

        RubberList<Integer> stack = new RubberList<>();
        for (int i = 0; i < 3; i++) {
            stack.push(i * 5);
            System.out.println(stack);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }
    }
}
