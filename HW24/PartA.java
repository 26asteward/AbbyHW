import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = in.nextLine();
            System.out.println("Name: " + name);
            
            System.out.print("Enter your age: ");
            int age = in.nextInt();
            System.out.println("Age: " + age);
        }
    }
}
