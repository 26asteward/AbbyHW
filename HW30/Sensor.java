public abstract class Sensor {
    private String name;
    private int modelNumber;

    /*
     * Constructor.
     */
    public Sensor(String name, int modelNumber) {
        this.name = name;
        this.modelNumber = modelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int newModelNumber) {
        modelNumber = newModelNumber;
    }

    /*
     * Abstract method that subclasses must implement.
     */
    public abstract void recordMeasurement();
}
