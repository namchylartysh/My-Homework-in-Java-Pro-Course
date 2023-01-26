package homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTestTest {
    private static Homework20 arr;

    static int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
    static int[] array2 = {1, 2, 4, 4, 2, 3, 4};
    static int[] array3 = {1, 2, 6, 5, 2, 3};

    static int[] res1 = {1, 7};
    static int[] res2 = {};
    static int[] res3 = {1, 2, 6, 5, 2, 3};

    @Test
    public void situation1() {
        Homework20 arr = new Homework20();
        Assertions.assertArrayEquals(res1, arr.arrayForTest(array1));
    }

    @Test
    public void situation2() {
        Homework20 arr = new Homework20();
        Assertions.assertArrayEquals(res2, arr.arrayForTest(array2));
    }

    @Test
    public void situation3() {
        Homework20 arr = new Homework20();
        Assertions.assertArrayEquals(res3, arr.arrayForTest(array3));
    }

}