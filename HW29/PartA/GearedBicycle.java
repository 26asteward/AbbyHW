package PartA;

public class GearedBicycle extends Bicycle {
    private final int MAX_GEAR = 6;
    private final int GEARED_MAX_SPEED = 50;
    private int currentGear;

    public GearedBicycle() {
        super();
        currentGear = 1;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int newGear) {
        if (newGear >= 1 && newGear <= MAX_GEAR) {
            currentGear = newGear;
        }
    }

    public void shiftUp() {
        if (currentGear < MAX_GEAR) {
            currentGear++;
        }
    }

    public void shiftDown() {
        if (currentGear > 1) {
            currentGear--;
        }
    }

    @Override
    public void pedal() {
        int newSpeed = getSpeed() + getCurrentGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    @Override
    public void brake() {
        int newSpeed = getSpeed() - 2;   
        if (newSpeed < 0) {
            newSpeed = 0;
        }
        setSpeed(newSpeed);
    }

    @Override
    public void display() {
        System.out.printf("Gear = %02d; Speed = %02d MPH%n", currentGear, getSpeed());
    }
}
