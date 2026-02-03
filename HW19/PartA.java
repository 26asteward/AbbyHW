import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        ArrayList<Integer> temperatures = new ArrayList<>();
        int lowest = Integer.MAX_VALUE;
        try {
            File file = new File("temps.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextInt()) {
                int temp = input.nextInt();
                temperatures.add(temp);

                if (temp < lowest) {
                    lowest = temp;
                }
            }
            input.close();
            for (int temp : temperatures) {
                if (temp == lowest) {
                    System.out.println(temp + " <= lowest");
                } else {
                    System.out.println(temp);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}