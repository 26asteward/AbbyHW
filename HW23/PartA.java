public class PartA {

	public static int getQuizScore(java.util.Scanner in) {
		String line;
		try {
			line = in.nextLine();
		} catch (java.util.NoSuchElementException e) {
			throw new NumberFormatException("No input available");
		}
		if (line == null) {
			throw new NumberFormatException("No input provided");
		}
		line = line.trim();
		int score;
		try {
			score = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Unable to parse integer");
		}
		if (score < 0 || score > 100) {
			throw new NumberFormatException("Score out of range: " + score);
		}
		return score;
	}

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.print("Enter quiz score (0-100): ");
		try {
			int score = getQuizScore(in);
			System.out.println("Valid score obtained: " + score);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: " + e.getMessage());
		} finally {
			in.close();
		}
	}

}
