import java.util.Scanner;

public class ProgrammingProject {
    public static void main(String[] args) {
        Die die = new Die();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter 'r' to roll, 'd' to display,or 'q' to quit: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("r")) {
                die.roll();
                System.out.println("die was rolled. value = " + die.getValue());
            } else if (input.equals("d")) {
                System.out.println();
            } else if (input.equals("q")) {
                System.out.println("Bye!");
                break;
            }
        }
        scanner.close();
    }
}