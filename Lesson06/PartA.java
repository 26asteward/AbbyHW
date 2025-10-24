
public class PartA { 
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a temperature and a 'C' for Celsius or 'F' for Fahrenheit: ");
        double temperature = scanner.nextDouble();
        String scaleToken = scanner.next();
        scanner.close();

        char scale = Character.toUpperCase(scaleToken.charAt(0));
        double celsius = (scale == 'F') ? (temperature - 32) * 5 / 9.0 : temperature;

        String state;
        if (celsius < 0) {
            state = "solid (i.e., ice)";
        } else if (celsius >= 100) {
            state = "gaseous (i.e., steam)";
        } else {
            state = "liquid (i.e., water)";
        }

        System.out.printf("At a temperature of %.2f %s, water is in a %s state.%n",
                celsius, "C", state);
    }
}
