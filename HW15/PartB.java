package HW15;

import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] values = new int[20];
        int currentSize = 0;

        while (currentSize < 20) {
            System.out.printf("Enter an integer value or 'q' to quit: ");
            if (input.hasNext("q") || input.hasNext("Q")) {
                input.next(); 
                break; 
            } else {
                int value = input.nextInt();
                values[currentSize] = value;
                currentSize++;
            }
        }

        for (int i = 0; i < currentSize; i++) {
            System.out.print(values[i]);
            if (i < currentSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Enter a target integer value: ");
        int target = input.nextInt();

        int count = 0;
        for (int i = 0; i < currentSize; i++) {
            if (values[i] == target) {
                count++;
            }
        }

        System.out.printf("The value %d occurs %d times in your original data set.\n", target, count);

        input.close();
    }
}
