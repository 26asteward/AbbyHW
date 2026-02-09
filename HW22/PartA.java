import java.io.*;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a filename or # to quit: ");
            String input = scanner.nextLine();
            
            if (input.equals("#")) {
                System.out.println("Goodbye!");
                break;
            }
            
            try {
                File file = new File(input);
                Scanner fileScanner = new Scanner(file);
                
                while (fileScanner.hasNext()) {
                    System.out.println(fileScanner.next());
                }
                
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                System.out.println("The file \"" + input + "\" was not found.");
            }
        }
        
        scanner.close();
    }
}
