import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        try {
            File file = new File("customerdata.txt");
            Scanner input = new Scanner(file);
            input.useDelimiter("[,\\s\\n]+");
            NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("-------------------------------------");
            System.out.printf("%7s | %10s | %12s%n", "ID", "Name", "Balance");
            System.out.println("----------------------------------");
            while (input.hasNext()) {
                int id = input.nextInt();
                String name = input.next();
                double balance = input.nextDouble();
                System.out.printf(
                        "%06d | %10s | %12s%n",
                        id,
                        name,
                        money.format(balance)
                );
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}