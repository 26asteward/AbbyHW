import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class PartC {

   
    public static void main(String[] args) {
        ArrayList<Integer> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a temperature (or 'q' to quit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            
            try {
                int temp = Integer.parseInt(input);
                temperatures.add(temp);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        
        if (temperatures.isEmpty()) {
            System.out.println("No temperatures entered.");
            scanner.close();
            return;
        }
        
        int lowestTemp = Collections.min(temperatures);
        
        System.out.println("\nTemperatures:");
        for (int temp : temperatures) {
            if (temp == lowestTemp) {
                System.out.println(temp + " <= lowest");
            } else {
                System.out.println(temp);
            }
        }
        
        scanner.close();
    }
}


