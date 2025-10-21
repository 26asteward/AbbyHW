import java.util.Scanner;

public class PartD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer (1 - 3999): ");
        int number = input.nextInt();

        if (number <= 0 || number > 3999) {
            System.out.println("Invalid input! Please enter a number between 1 and 3999.");
        } else {
            String roman = convertToRoman(number);
            System.out.println("Roman numeral: " + roman);
        }

        input.close();
    }

    public static String convertToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousandDigit = num / 1000;
        int hundredDigit  = (num % 1000) / 100;
        int tenDigit      = (num % 100) / 10;
        int oneDigit      = num % 10;

        return thousands[thousandDigit] + hundreds[hundredDigit] + tens[tenDigit] + ones[oneDigit];
    }
}

