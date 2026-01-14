import java.util.Arrays;

public class PartB {

    public static void main(String[] args) {

        System.out.println("Average of (10, 8, 9): " + average(10, 8, 9));

        double[] scores = {100, 90, 80, 100, 80};
        System.out.println("Average of scores array: " + average(scores));

        double[] testScores = new double[10];
        int size = 5;

        testScores[0] = 85;
        testScores[1] = 90;
        testScores[2] = 88;
        testScores[3] = 92;
        testScores[4] = 95;

        double[] validScores = Arrays.copyOf(testScores, size);

        System.out.println("Average of partially filled array: " + average(validScores));
    }

    public static double average(double... values) {
        if (values.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double num : values) {
            sum += num;
        }

        return sum / values.length;
    }
}


    


