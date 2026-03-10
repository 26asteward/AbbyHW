public class Die {

    private int value;

    public Die() {
        roll();
    }

    public Die(int initialValue) {
        value = initialValue;
    }

    public void roll() {
        value = (int)(Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void display() {

        switch(value) {
            case 1:
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   0   |");
                System.out.println("|       |");
                System.out.println("+-------+");
                break;

            case 2:
                System.out.println("+-------+");
                System.out.println("| 0     |");
                System.out.println("|       |");
                System.out.println("|     0 |");
                System.out.println("+-------+");
                break;

            case 3:
                System.out.println("+-------+");
                System.out.println("| 0     |");
                System.out.println("|   0   |");
                System.out.println("|     0 |");
                System.out.println("+-------+");
                break;

            case 4:
                System.out.println("+-------+");
                System.out.println("| 0   0 |");
                System.out.println("|       |");
                System.out.println("| 0   0 |");
                System.out.println("+-------+");
                break;

            case 5:
                System.out.println("+-------+");
                System.out.println("| 0   0 |");
                System.out.println("|   0   |");
                System.out.println("| 0   0 |");
                System.out.println("+-------+");
                break;

            case 6:
                System.out.println("+-------+");
                System.out.println("| 0   0 |");
                System.out.println("| 0   0 |");
                System.out.println("| 0   0 |");
                System.out.println("+-------+");
                break;
        }
    }
}

