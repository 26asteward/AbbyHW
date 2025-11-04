import java.util.Scanner;
public class PartB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == 'e') {
                count++;
            }
        }
        System.out.println("The letter 'e' occurred " + count + " times.");
        scanner.close();
    }
}