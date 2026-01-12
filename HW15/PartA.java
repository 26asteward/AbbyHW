package HW15;

import java.util.Arrays;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[10];
        int currentSize = 0;

        System.out.println("Enter up to 10 integer values (type 'q' to quit):");

        while (currentSize < 10) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                values[currentSize] = value;
                currentSize++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'q' to quit.");
            }
        }

        System.out.print("*");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(values[i] + "*");
        }
        System.out.println();

        Arrays.sort(values, 0, currentSize);

        for (int i = currentSize - 1; i >= 0; i--) {
            System.out.print(values[i]);
            if (i > 0) {
                System.out.print(",");
            }
        }
        System.out.println();

        scanner.close();
    }
}