 import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
   public static void main(String[] args) {
      ArrayList<String> names = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      
      while (true) {
         System.out.print("Enter a name (or # to quit): ");
         String input = scanner.nextLine();
         
         if (input.equals("#")) {
            break;
         }
         
         names.add(input);
      }
      
      System.out.println("\nNames entered:");
      for (String name : names) {
         System.out.println(name);
      }
      
      scanner.close();
   }
}
