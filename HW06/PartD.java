package Lesson06;

public class PartD {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the number of cookies: ");
        int numCookies = scanner.nextInt();
        scanner.close();

        double pricePerCookie = 0.99;
        double totalCost = numCookies * pricePerCookie;
        double discount = 0.0;

        if (numCookies >= 24) {
            discount = 0.15;
        } else if (numCookies >= 12) {
            discount = 0.05;
        } else if (numCookies >= 6) {
            discount = 0.025;
        }

        totalCost -= totalCost * discount;

        System.out.printf("Total cost: $%.2f%n", totalCost);
    }
}
