package HW15;

import java.util.Arrays;
import java.util.Random;

public class PartC {
   
 
    public static void main(String[] args) {
        final int SIZE = 10000;
        int[] array = new int[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(SIZE) + 1;
        }

        Arrays.sort(array);

        System.out.println("Testing search performance on array of size " + SIZE + ":");
        System.out.println("Target\tLinear Time (ns)\tFound\tBinary Time (ns)\tFound");

        for (int test = 0; test < 10; test++) {
            int target = rand.nextInt(SIZE) + 1;

            long start = System.nanoTime();
            int linearResult = linearSearch(array, target);
            long linearTime = System.nanoTime() - start;

            start = System.nanoTime();
            int binaryResult = Arrays.binarySearch(array, target);
            long binaryTime = System.nanoTime() - start;

            System.out.printf("%d\t%d\t\t%b\t%d\t\t%b\n", target, linearTime, linearResult != -1, binaryTime, binaryResult >= 0);
        }

    }

    public static int linearSearch(int[] array, int tgtVal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tgtVal) {
                return i; 
            }
        }
        return -1; 

    }
}
