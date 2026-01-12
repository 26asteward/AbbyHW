import java.util.Scanner;

public class InClassPartB {

    public static int remove(double[] array, int currentSize, int targetIndex) {
        if (targetIndex < 0 || targetIndex >= currentSize) {
            return currentSize;
        }

        for (int i = targetIndex; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }

        return currentSize - 1;
    }

    public static int insert(double[] array, int currentSize, int targetIndex, double newElement) {

        if (currentSize >= array.length) {
            return currentSize;
        }

        if (targetIndex < 0 || targetIndex > currentSize) {
            return currentSize;
        }

        for (int i = currentSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }

        array[targetIndex] = newElement;

        return currentSize + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[10];
        int count = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;

        while (count < scores.length) {
            System.out.print("Enter score (or 'Q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                double score = Double.parseDouble(input);

                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Enter 0–100.");
                    continue;
                }

                scores[count] = score;
                count++;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }

        if (count == 0) {
            System.out.println("No scores entered.");
            scanner.close();
            return;
        }

        for (int i = 0; i < count; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        System.out.println("\nOriginal Data:");
        System.out.println("Count: " + count);
        System.out.printf("Average: %.2f%n", sum / count);
        System.out.println("Max: " + max);

        System.out.print("\nEnter index to remove (0 to " + (count - 1) + "): ");
        int removeIndex = Integer.parseInt(scanner.nextLine());
        count = remove(scores, count, removeIndex);

        sum = 0;
        max = Double.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        System.out.println("\nAfter Removal:");
        System.out.println("Count: " + count);
        System.out.printf("Average: %.2f%n", sum / count);
        System.out.println("Max: " + max);

        System.out.print("\nEnter index to insert (0 to " + count + "): ");
        int insertIndex = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter score to insert: ");
        double newScore = Double.parseDouble(scanner.nextLine());

        count = insert(scores, count, insertIndex, newScore);

        sum = 0;
        max = Double.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        System.out.println("\nAfter Insertion:");
        System.out.println("Count: " + count);
        System.out.printf("Average: %.2f%n", sum / count);
        System.out.println("Max: " + max);

        scanner.close();
    }
}

