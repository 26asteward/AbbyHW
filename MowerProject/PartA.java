import java.util.Scanner;
import mow.Yard;

public class PartA {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the height of the yard: ");
            int height = scanner.nextInt();

            System.out.print("Enter the width of the yard: ");
            int width = scanner.nextInt();

            clearScreen();
            System.out.println();

            Yard yard = new Yard(height, width);
            yard.printYard();
        }
    }
}

