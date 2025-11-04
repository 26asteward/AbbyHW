import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter test scores to calculate the average.");
        System.out.println("Enter a negative number to finish input.");
        
        double sum = 0;
        int count = 0;
        
        while (true) {
            System.out.print("Enter test score: ");
            double score = scanner.nextDouble();
            
            if (score < 0) {
                break;
            }
            
            sum += score;
            count++;
        }
        
        if (count > 0) {
            double average = sum / count;
            System.out.println("Number of scores entered: " + count);
            System.out.printf("Average test score: %.2f%n", average);
        } else {
            System.out.println("No scores were entered.");
        }
        
        scanner.close();
    }
}