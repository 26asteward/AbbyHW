import java.util.ArrayList;
import java.util.Scanner;

class CashRegister {
   private ArrayList<Double> items;

 
   public CashRegister() {
       items = new ArrayList<Double>();
   }

  
   public void addItem(double price) {
       items.add(price);
   }

  
   public void removeItem() {
       if (items.size() > 0) {
           items.remove(items.size() - 1);
       }
   }


   public double getTotal() {
       double total = 0;
       for (double price : items) {
           total += price;
       }
       return total;
   }

  
   public int getCount() {
       return items.size();
   }

  
   public void clear() {
       items.clear();
   }
}

public class PartB {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Cash Register Program!");
        System.out.println("Commands:");
        System.out.println("  Enter a number - add item price");
        System.out.println("  't' - display total and count");
        System.out.println("  'd' - delete most recent item");
        System.out.println("  'c' - clear register");
        System.out.println("  'q' - quit");
        System.out.println();

        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equals("q")) {
                running = false;
                System.out.println("Thank you for using the Cash Register!");
            } else if (input.equals("t")) {
                System.out.printf("Item Count: %d%n", register.getCount());
                System.out.printf("Total: $%.2f%n", register.getTotal());
            } else if (input.equals("d")) {
                register.removeItem();
                System.out.println("Most recent item removed.");
            } else if (input.equals("c")) {
                register.clear();
                System.out.println("Register cleared.");
            } else {
                try {
                    double price = Double.parseDouble(input);
                    register.addItem(price);
                    System.out.printf("Added $%.2f to the register.%n", price);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or a valid command.");
                }
            }
        }

        scanner.close();
    }
}
