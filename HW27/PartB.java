import java.util.Scanner;
import org.derryfield.math.Geometry;

public class PartB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of a side of a square: ");
        double sideLength = scanner.nextDouble();
        
        double perimeter = Geometry.get_perimeter_square(sideLength);
        double area = Geometry.get_area_square(sideLength);
        
        System.out.println("Side length: " + sideLength);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
        
        scanner.close();
    }
}
