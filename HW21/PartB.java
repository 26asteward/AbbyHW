import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartB {
	public static void main(String[] args) {
		String file = "sales_by_cat.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				String[] parts = line.split(",");
				if (parts.length < 3) continue;
				String dept = parts[0].trim();
				String manager = parts[1].trim();
				String salesStr = parts[2].trim();
				double sales = 0.0;
				if (!salesStr.equalsIgnoreCase("n/a")) {
					try {
						sales = Double.parseDouble(salesStr);
					} catch (NumberFormatException ex) {
						sales = 0.0;
					}
				}
				System.out.printf("%-15s | %-7s | $ %8.2f%n", dept, manager, sales);
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}
}
