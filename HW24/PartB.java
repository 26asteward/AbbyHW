import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Counter cakeCounter = new Counter();
        Counter pieCounter = new Counter();
        
        try (Scanner in = new Scanner(System.in)) {
            String choice = "";
            
            while (!choice.equals("q")) {
                System.out.print("Enter 'c' for cake, 'p' for pie, or 'q' to quit: ");
                choice = in.nextLine().toLowerCase();
                
                if (choice.equals("c")) {
                    cakeCounter.increment();
                    System.out.println("Vote for cake recorded!");
                } else if (choice.equals("p")) {
                    pieCounter.increment();
                    System.out.println("Vote for pie recorded!");
                } else if (choice.equals("q")) {
                    System.out.println("Quitting...");
                } else {
                    System.out.println("Invalid entry. Please enter 'c', 'p', or 'q'.");
                }
            }
        }
        
        System.out.println("\n--- Final Results ---");
        System.out.println("Total votes for cake: " + cakeCounter.getValue());
        System.out.println("Total votes for pie: " + pieCounter.getValue());
    }
}