import java.io.*;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        String filename = "data.txt";
        
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");
                
                if (fields.length >= 2) {
                    String name = fields[0];
                    String birthYearStr = fields[1];
                    
                    try {
                        int birthYear = Integer.parseInt(birthYearStr);
                        System.out.println(name + " was born in " + birthYear + ".");
                    } catch (NumberFormatException e) {
                        System.out.println("I do not know what year " + name + " was born.");
                    }
                }
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
