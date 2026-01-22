import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class PartD {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integer values (or 'q' to quit):");
        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            
            try {
                Integer num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num % 2 != 0) {  
                iterator.remove();
            }
        }
        
        System.out.println("\nModified list (even numbers only):");
        for (Integer num : numbers) {
            System.out.println(num);
        }
        
        scanner.close();
    }
}
