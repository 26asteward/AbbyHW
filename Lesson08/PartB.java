
public class PartB {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the APR (as a percentage, for example, 5.5): ");
        double apr = scanner.nextDouble();

        System.out.print("Enter the balance: ");
        double balance = scanner.nextDouble();

        System.out.println("Year |        Int Earned ($)       |           Balance ($)");
        System.out.println("----------------------------------------------------------------------");

        for (int year = 1; year <= 5; year++) {
            double interestEarned = balance * (apr / 100);
            balance += interestEarned;

            System.out.printf("  %d  | %25.2f | %25.2f%n", year, interestEarned, balance);
        }

        scanner.close();
    }
}