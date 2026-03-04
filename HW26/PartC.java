/* output:
150.0
150.0
Customer c2 = c1; makes c2 refer to the same 
object as c1. So when you do 
c2.addSale(50);, you’re adding a sale to the s
ame customer object that c1 points to. Therefore
both c1.getSales() and c2.getSales() return the 
same total sales (100 + 50). */

public class PartC {

    private String companyName;
    private double totalSales;
    private int numberSales;
    private int regionCode;

    private int serialNumber;
    public static int lastSerialUsed = 0;

    public void Customer(String name, int regionCode) {
        companyName = name;
        totalSales = 0;
        numberSales = 0;
        this.regionCode = regionCode;

        lastSerialUsed++;
        serialNumber = lastSerialUsed;
    }

    public void Customer(String name) {
        companyName = name;
        totalSales = 0;
        numberSales = 0;
        regionCode = 1;

        lastSerialUsed++;
        serialNumber = lastSerialUsed;
    }

    public String getName() {
        return companyName;
    }

    public void setName(String new_name) {
        companyName = new_name;
    }

    public void setRegion(int new_region) {
        regionCode = new_region;
    }

    public int getRegion() {
        return regionCode;
    }

    public void addSale(double amount) {
        this.totalSales = this.totalSales + amount;
        this.numberSales++;
    }

    public double getSales() {
        return totalSales;
    }

    public int getNumber() {
        return numberSales;
    }

    public double getAverage() {
        if (numberSales == 0) {
            return 0;
        }
        return totalSales / numberSales;
    }

    public int getSerial() {
        return serialNumber;
    }

    public static double getTaxRate(int regionCode) {
        if (regionCode == 1) return 0.0000;
        if (regionCode == 2) return 0.0550;
        if (regionCode == 3) return 0.0600;
        if (regionCode == 4) return 0.0625;
        return 0.0;
    }
}
