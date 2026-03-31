
import java.util.Scanner;
public class TriangleClassifiar {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter length of side 1: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter an integer value.");
                return;
            }
            int side1 = scanner.nextInt();

            System.out.print("Enter length of side 2: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter an integer value.");
                return;
            }
            int side2 = scanner.nextInt();

            System.out.print("Enter length of side 3: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter an integer value.");
                return;
            }
            int side3 = scanner.nextInt();
            
            if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                System.out.println("Error: Side lengths must be greater than zero.");
                return;
            }

            if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
                System.out.println("Not a triangle");
            } else if (side1 == side2 && side2 == side3) {
                System.out.println("Equilateral");
            } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}


        
    