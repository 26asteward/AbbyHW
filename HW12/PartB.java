import java.util.Scanner;

public class PartB {
    
   public static double smallest(double x, double y, double z)
   {
      double min = x;
      if (y < min)
         min = y;
      if (z < min)
         min = z;
      return min;
   }


   public static void main(String[] args)
   {
      try (Scanner in = new Scanner(System.in)) {
        System.out.print("Enter the first number: ");
          double x = in.nextDouble();

          System.out.print("Enter the second number: ");
          double y = in.nextDouble();

          System.out.print("Enter the third number: ");
          double z = in.nextDouble();

          double result = smallest(x, y, z);
          System.out.println("The smallest value is: " + result);
      }
   }
}
