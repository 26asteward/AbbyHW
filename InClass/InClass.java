
package InClass;

import java.util.Scanner;

public class InClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[10];
        int count = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (count < 10) {
            System.out.print("Enter score (or 'Q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                int score = Integer.parseInt(input);
                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Please enter a score between 0 and 100.");
                    continue;
                }
                scores[count] = score;
                sum += score;
                if (score > max) {
                    max = score;
                }
                count++;
            
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid score or 'Q' to quit.");
            }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Count: " + count);
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Max: " + max);
        } else {
            System.out.println("No scores entered.");
        }

        scanner.close();
    }
}
}
    
