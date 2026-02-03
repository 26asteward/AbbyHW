import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        ArrayList<Double> quizScores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter quiz scores (or 'q' to quit):");
        while (true) {
            System.out.print("Enter score: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            
            try {
                double score = Double.parseDouble(input);
                quizScores.add(score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'q' to quit.");
            }
        }
        
        scanner.close();
        
        
        System.out.println("\nQuiz Scores:");
        System.out.println("------------");
        for (double score : quizScores) {
            System.out.printf("%8.2f%n", score);
        }
        
        double sum = 0;
        for (double score : quizScores) {
            sum += score;
        }
        double average = sum / quizScores.size();
        
        System.out.println("------------");
        System.out.printf("Average: %8.2f%n", average);
    }
}
