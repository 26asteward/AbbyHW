public class BaseballCard {
    String name; 
    int year; 

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "BaseballCard{name='" + name + "', year=" + year + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseballCard that = (BaseballCard) obj;
        return year == that.year && java.util.Objects.equals(name, that.name);
    }

    public static void main(String[] args) {
        BaseballCard card1 = new BaseballCard("Babe Ruth", 1927);
        BaseballCard card2 = new BaseballCard("Babe Ruth", 1927);
        BaseballCard card3 = new BaseballCard("Willie Mays", 1951);

        System.out.println("Card 1: " + card1.toString());
        System.out.println("Card 2: " + card2.toString());
        System.out.println("Card 3: " + card3.toString());

        System.out.println("Card 1 equals Card 2: " + card1.equals(card2));
        System.out.println("Card 1 equals Card 3: " + card1.equals(card3));
        System.out.println("Card 2 equals Card 3: " + card2.equals(card3));
    }
}