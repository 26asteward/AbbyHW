public class PartB {
    public static void main(String[] args) {
        double[] numbers = { 2.2, 1.0, 3.7, 4.1, 88.0 };
        double sum = 0.0;

        for (double num : numbers) {
            System.out.println(num);
            sum += num;
        }

        double average = sum / numbers.length;
        System.out.println("Average: " + average);
    }
}