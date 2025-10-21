import java.util.Scanner;

public class PartB {

    enum CustomerType { CHILD, ADULT, SENIOR }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Is it Monday? (true/false): ");
            boolean isMonday = scanner.nextBoolean();

            System.out.print("Enter the age of the customer: ");
            int age = scanner.nextInt();

            System.out.print("Enter the cost of the meal: ");
            double mealCost = scanner.nextDouble();

            CustomerType customerType;
            if (age < 13) {
                customerType = CustomerType.CHILD;
            } else if (age >= 50) {
                customerType = CustomerType.SENIOR;
            } else {
                customerType = CustomerType.ADULT;
            }

            double discount = 0;

            switch (customerType) {
                case CHILD:
                    discount = isMonday ? 7.5 : 5;
                    break;
                case SENIOR:
                    discount = isMonday ? 15 : 7.5;
                    break;
                case ADULT:
                    discount = 5;
                    break;
            }

            double discountedCost = mealCost - (mealCost * discount / 100);
            System.out.println("Customer Type: " + customerType);
            System.out.println("The discounted cost is: " + discountedCost);
        }
    }
}