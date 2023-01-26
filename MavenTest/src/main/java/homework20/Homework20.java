package homework20;

import java.util.Arrays;

public class Homework20 {

    public int[] arrayForTest(int[] x) {
        int[] result = new int[]{0};
        for (int i = x.length - 1; i > 0; i--) {
            if (x[i] == 4) {
                int[] newArray = new int[x.length - i - 1];
                System.arraycopy(x, i + 1, newArray, 0, x.length - i - 1);
                result = newArray;
                break;
            } else {
                result = x;
            }
        }
        return result;
    }
}
