
public class PartC {
    public static void main(String[] args) {
        int sum = 0;
        int count = 1000; 

        for (int i = 0; i < count; i++) {
            int randomNum = (int)(Math.random() * 10) + 1; 
            sum += randomNum;
        }

        double average = (double) sum / count;
        System.out.printf("The average of %d random integers is: %.2f%n", count, average);
    }
}
/* The average value makes sense because with a distribution of integers from 1 to 10,
the expected average is around the midpoint, which is 5.5. As we increase the number of samples,
the calculated average should converge closer to this expected value.
 */