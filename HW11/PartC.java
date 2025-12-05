
public class PartC {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Enter the radius of the sphere: ");
            double radius = scanner.nextDouble();
            double volume = calculateSphereVolume(radius);
            System.out.printf("The volume of the sphere with radius %.2f is %.2f%n", radius, volume);
        }
    }

    private static double calculateSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

}
