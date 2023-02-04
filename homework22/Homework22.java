package homework22;

/**
 * Java Professional Homework #22
 *
 * @author Artysh
 * @version 30.01 - 4.02
 */

import java.util.Arrays;

public class Homework22 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];

        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + leftHalf[i] / 5) * Math.cos(0.2f + leftHalf[i] / 5) * Math.cos(0.4f + leftHalf[i] / 2));
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + rightHalf[i] / 5) * Math.cos(0.2f + rightHalf[i] / 5) * Math.cos(0.4f + rightHalf[i] / 2));
            }
        });

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        float[] mergedArray = new float[SIZE];
        System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(rightHalf, 0, mergedArray, HALF, HALF);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

}
