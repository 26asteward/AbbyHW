public class Challenge4 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter an integer value from 0 to 20: ");
        int value = scanner.nextInt();
        
        if (value < 0 || value > 20) {
            System.out.println("Please enter a valid integer between 0 and 20.");
        } else {
            int percentage = (value * 100) / 20;
            int filledLength = value;
            int emptyLength = 20 - filledLength;
            
            StringBuilder progressBar = new StringBuilder();
            progressBar.append("Progress: [");
            for (int i = 0; i < filledLength; i++) {
                progressBar.append("#");
            }
            for (int i = 0; i < emptyLength; i++) {
                progressBar.append("-");
            }
            progressBar.append("] ").append(percentage).append("%");
            
            System.out.println(progressBar.toString());
        }
        
        scanner.close();
    }
}
