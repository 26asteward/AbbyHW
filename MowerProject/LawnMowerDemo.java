import java.util.Scanner;
import mow.Yard;
import mow.Mower;

public class LawnMowerDemo {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        clearScreen();
        System.out.print("Enter the height of the yard: ");
        int height = input.nextInt();

        System.out.print("Enter the width of the yard: ");
        int width = input.nextInt();

        Yard yard = new Yard(height, width);
        Mower mower = new Mower();

        mower.randomizePosition(yard);

        clearScreen();
        yard.printYard(mower);
        delay(500);

        while (true) {
            boolean keepGoing = mower.updateMower(yard);

            clearScreen();
            yard.printYard(mower);
            delay(500);

            if (!keepGoing) {
                break;
            }
        }

        System.out.println();
        System.out.println("Mowing complete.");

        input.close();
    }
}
