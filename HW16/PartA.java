import java.util.Scanner;

public class PartA {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
          String[] words = new String[20]; 
          int size = 0;

          while (true) {
              System.out.print("Enter a word or phrase or 'q' to quit: ");
              String input = in.nextLine();

              if (input.equals("q")) {
                  break;
              }

              words[size] = input;
              size++;
          }

          System.out.println("\nWords/Phrases (current size = " + size + "):");
          printArray(words, size);

          cleanup(words, size);

          System.out.println("\nModified array...");
          System.out.println("Words/Phrases (current size = " + size + "):");
          printArray(words, size);
        }
    }

    public static void printArray(String[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println("  " + arr[i]);
        }
    }

    public static void cleanup(String[] arr, int size) {
        for (int i = 0; i < size; i++) {
            String s = arr[i].trim().toLowerCase();

            if (s.length() > 0) {
                s = s.substring(0, 1).toUpperCase() + s.substring(1);
            }

            arr[i] = s;
        }
    }
}


