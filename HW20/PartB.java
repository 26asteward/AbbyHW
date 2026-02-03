import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class PartB {
    public static void main(String[] args) {
        File file = new File("characters.txt");
        int count = 0;
        int letters = 0;
        int digits = 0;
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                char c = (char) ch;
                System.out.print(c);
                count++;
                if (Character.isLetter(c)) {
                    letters++;
                } else if (Character.isDigit(c)) {
                    digits++;
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or cannot read file.");
        }
        System.out.println();
        System.out.println("count = " + count);
        System.out.println("letters = " + letters);
        System.out.println("digits = " + digits);
    }
}

