public class PartC {
    public static void main(String[] args) {
        double a = 1.2;
        double b = 3.0;
        double c = a * b;

        c = Math.round(c * 10.0) / 10.0;

        if (c == 3.6) {
            System.out.println("c is 3.6");
        } else {
            System.out.println("c is not 3.6");
        }
    }
}
