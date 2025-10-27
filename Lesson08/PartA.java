
public class PartA {

    public static void main(String[] args) {
        double cesiumAmount = 100.0;
        int years = 0;

        while (cesiumAmount > 1.0) {
            cesiumAmount /= 2;
            years += 30;
        }

        System.out.println("Years required: " + years);
        System.out.println("Amount of cesium left: " + cesiumAmount + "%");
    }
}
