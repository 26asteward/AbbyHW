import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("quizzez.txt"));
            PrintWriter output = new PrintWriter("quizzizMod.txt");
            int quizNumber = 0;
            double total = 0.0;
            int count = 0;
            while (input.hasNextDouble()) {
                double score = input.nextDouble();
                total += score;
                count++;
                output.printf("Quiz %03d: %6.2f%n", quizNumber, score);
                quizNumber++;
            }
            output.println("----------------");
            output.printf("Average:   %6.2f%n", total / count);
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}





