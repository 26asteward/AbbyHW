package PartA;

public class BicycleBrakeDemo {
    public static void main(String[] args) {
        Bicycle regularBike = new Bicycle();
        GearedBicycle gearedBike = new GearedBicycle();

        regularBike.pedal();
        regularBike.pedal();
        regularBike.pedal();
        regularBike.pedal();

        gearedBike.shiftUp();   
        gearedBike.shiftUp();   
        gearedBike.pedal();     
        gearedBike.pedal();     

        System.out.println("Before braking:");
        System.out.print("Regular bike: ");
        regularBike.display();
        System.out.print("Geared bike: ");
        gearedBike.display();

        regularBike.brake();
        gearedBike.brake();

        System.out.println();
        System.out.println("After braking once:");
        System.out.print("Regular bike: ");
        regularBike.display();
        System.out.print("Geared bike: ");
        gearedBike.display();
    }
}