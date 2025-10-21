import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Is it Monday? (true/false): ");
            boolean isMonday = scanner.nextBoolean();

            System.out.print("Enter the age of the customer: ");
            int age = scanner.nextInt();

            System.out.print("Enter the cost of the meal: ");
            double mealCost = scanner.nextDouble();

            double discount = 0;

            if (isMonday) {
                if (age < 13) {
                    discount = 7.5;
                } else if (age >= 50) {
                    discount = 15;
                } else {
                    discount = 5;
                }
            } else {
                if (age < 13) {
                    discount = 5;
                } else if (age >= 50) {
                    discount = 7.5;
                } else {
                    discount = 5;
                }
            }

            double discountedCost = mealCost - (mealCost * discount / 100);
            System.out.println("The discounted cost is: " + discountedCost);
        }
    }
}

