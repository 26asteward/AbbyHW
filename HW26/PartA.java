/* constant static value 
Math.PI (π)
static method
Math.sqrt(x)  */
public class PartA {
    public static void main(String[] args) {

        double radius = 4.0;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        System.out.printf("Radius = %.2f%n", radius);
        System.out.printf("Circumference = %.2f%n", circumference);
        System.out.printf("Area = %.2f%n", area);


        double a = 3.0;
        double b = 4.0;
        double hypotenuse = Math.sqrt(a * a + b * b);

        System.out.printf("Hypotenuse of %.1f and %.1f = %.2f%n", a, b, hypotenuse);
    }
}

