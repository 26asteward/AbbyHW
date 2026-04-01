public class Executive extends Manager {
    private double shares;

    /*
     * Constructor.
     */
    public Executive(String name, double salary, double bonus, double shares) {
        // invoke the parent class' constructor.
        super(name, salary, bonus);

        // initialize the child class' members.
        this.shares = shares;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double newShares) {
        shares = newShares;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Shares = %,12.2f%n", shares);
    }
}
