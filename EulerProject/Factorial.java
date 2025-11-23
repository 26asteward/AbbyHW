public class Factorial {
// have them enter a number and return the factorial of that number
    public static void main(String[] args) {
        int number = 5; 
        long result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}