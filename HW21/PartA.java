import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PartA {

	static class Entry {
		String country;
		double rate;
		int rank;
		String region;

		Entry(String country, double rate, int rank, String region) {
			this.country = country;
			this.rate = rate;
			this.rank = rank;
			this.region = region;
		}
	}

	public static void main(String[] args) {
		List<Entry> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Top5Unemployment.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				String[] parts = line.split(",");
				if (parts.length < 4) continue;
				String country = parts[0].trim();
				double rate = Double.parseDouble(parts[1].trim());
				int rank = Integer.parseInt(parts[2].trim());
				String region = parts[3].trim();
				list.add(new Entry(country, rate, rank, region));
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return;
		}

		Collections.sort(list, Comparator.comparingInt(e -> e.rank));

		String sep = "---------------------------------------------------------------";
		System.out.println(sep);
		System.out.println("                   Top 5 Unemployment Rates");
		System.out.println(sep);

		for (Entry e : list) {
			System.out.printf("Ranked # %2d: %-17s |  %6.2f%% | %-22s%n",
					e.rank, e.country, e.rate, e.region);
		}

		System.out.println(sep);
	}
}
