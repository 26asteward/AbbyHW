import java.util.Random;

public class Card {
    public enum Suit {
        SPADE, HEART, CLUB, DIAMOND
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private Suit suit;
    private Rank rank;
    private static final Random random = new Random();

    public Card() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        this.suit = suits[random.nextInt(suits.length)];
        this.rank = ranks[random.nextInt(ranks.length)];
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getFace() {
        char suitChar;
        switch (suit) {
            case SPADE:
                suitChar = '\u2660';
                break;
            case HEART:
                suitChar = '\u2661';
                break;
            case CLUB:
                suitChar = '\u2663';
                break;
            case DIAMOND:
                suitChar = '\u2662';
                break;
            default:
                suitChar = '?'; 
        }

        char rankChar;
        switch (rank) {
            case TWO:
                rankChar = '2';
                break;
            case THREE:
                rankChar = '3';
                break;
            case FOUR:
                rankChar = '4';
                break;
            case FIVE:
                rankChar = '5';
                break;
            case SIX:
                rankChar = '6';
                break;
            case SEVEN:
                rankChar = '7';
                break;
            case EIGHT:
                rankChar = '8';
                break;
            case NINE:
                rankChar = '9';
                break;
            case TEN:
                rankChar = 'T';
                break;
            case JACK:
                rankChar = 'J';
                break;
            case QUEEN:
                rankChar = 'Q';
                break;
            case KING:
                rankChar = 'K';
                break;
            case ACE:
                rankChar = 'A';
                break;
            default:
                rankChar = '?'; 
        }
        return "" + suitChar + rankChar;
    }

    public static void main(String[] args) {
        Card queenHearts = new Card(Suit.HEART, Rank.QUEEN);
        System.out.println("The following card should be the queen of hearts,");
        System.out.println("  " + queenHearts.getFace());

        System.out.println("10 random cards...");
        for (int i = 0; i < 10; i++) {
            Card randomCard = new Card();
            System.out.println("  " + randomCard.getFace());
        }
    }
}
