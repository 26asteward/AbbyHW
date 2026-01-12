import java.util.Scanner;

public class InClassPartA {
    public static int remove(double[] array, int currentSize, int targetIndex) {
        if (targetIndex < 0 || targetIndex >= currentSize) {
            return currentSize; 
        }
        for (int i = targetIndex; i < currentSize - 1; i++) {
            array[i] = array[i + 1]; 
        }
        return currentSize - 1; 

        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[10];
        int count = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;

        while (count < 10) {
            System.out.print("Enter score (or 'Q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                double score = Double.parseDouble(input);
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
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("Count: " + count);
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Max: " + max);
        } else {
            System.out.println("No scores entered.");
        }

        if (count > 0) {
            System.out.print("Enter index to remove (0 to " + (count - 1) + "): ");
            String indexInput = scanner.nextLine();
            try {
                int index = Integer.parseInt(indexInput);
                int newCount = remove(scores, count, index);
                if (newCount != count) {
                    sum = 0;
                    max = Double.MIN_VALUE;
                    for (int i = 0; i < newCount; i++) {
                        sum += scores[i];
                        if (scores[i] > max) {
                            max = scores[i];
                        }
                    }
                    double average = sum / newCount;
                    System.out.println("After removal:");
                    System.out.println("Count: " + newCount);
                    System.out.printf("Average: %.2f%n", average);
                    System.out.println("Max: " + max);
                } else {
                    System.out.println("Invalid index, no removal performed.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid index.");
            }
        }

        scanner.close();
    }
}
