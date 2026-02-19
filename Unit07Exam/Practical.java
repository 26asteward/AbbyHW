import java.io.*;

public class Practical {
    public static void main(String[] args) {
        String fileName = "mathmeet.txt";
        double sum = 0.0;
        int count = 0;

        System.out.printf("%-25s | %-15s | %s%n", "Name", "School", "Score");
        System.out.println("-----------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length < 3) continue;
                String name = parts[0].trim();
                String school = parts[1].trim();
                String scoreStr = parts[2].trim();
                double score = Double.parseDouble(scoreStr);
                System.out.printf("%-25s | %-15s | %5.1f%n", name, school, score);
                sum += score;
                count++;
            }

            if (count > 0) {
                double avg = sum / count;
                System.out.println();
                    System.out.println("-----------------------------------------------------------");
                System.out.printf("Average score: %.2f%n", avg);
            } else {
                System.out.println("No valid records found in " + fileName);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
        }
    }
}

