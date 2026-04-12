import java.util.*;

public class Blackjack {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        System.out.println("Welcome to Blackjack!");

        while (true) {
            System.out.println("\nDo you want to play a hand? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
            playHand();
        }
    }

    private static void playHand() {
        clearScreen();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();

        playerHand.add(dealCard());
        dealerHand.add(dealCard()); 
        playerHand.add(dealCard());
        dealerHand.add(dealCard()); 

        int playerScore = calculateScore(playerHand);
        int dealerScore = calculateScore(dealerHand);

        System.out.println("Dealer's hand: " + dealerHand.get(0) + " and [hidden card]");
        System.out.println("Your hand: " + playerHand);
        System.out.println("Your score: " + playerScore);

        if (playerScore == 21) {
            if (dealerScore == 21) {
                System.out.println("Both have 21! It's a draw.");
                return;
            } else {
                System.out.println("Blackjack! You win!");
                return;
            }
        }

        if (dealerHand.get(0).getValue() >= 10 && dealerScore == 21) {
            System.out.println("Dealer reveals: " + dealerHand.get(1));
            System.out.println("Dealer has 21! You lose.");
            return;
        }

        while (true) {
            System.out.println("\nDo you want to hit or stand? (h/s)");
            String action = scanner.nextLine().trim().toLowerCase();
            if (action.equals("h")) {
                playerHand.add(dealCard());
                playerScore = calculateScore(playerHand);
                System.out.println("Your hand: " + playerHand);
                System.out.println("Your score: " + playerScore);
                if (playerScore > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (action.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }

        System.out.println("\nDealer's turn:");
        System.out.println("Dealer reveals: " + dealerHand.get(1));
        System.out.println("Dealer's hand: " + dealerHand);
        dealerScore = calculateScore(dealerHand);
        System.out.println("Dealer's score: " + dealerScore);

        while (dealerScore < 17) {
            delay(1000);
            dealerHand.add(dealCard());
            dealerScore = calculateScore(dealerHand);
            System.out.println("Dealer hits: " + dealerHand.get(dealerHand.size() - 1));
            System.out.println("Dealer's hand: " + dealerHand);
            System.out.println("Dealer's score: " + dealerScore);
        }

        if (dealerScore > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static Card dealCard() {
        String suit = SUITS[random.nextInt(SUITS.length)];
        String rank = RANKS[random.nextInt(RANKS.length)];
        return new Card(suit, rank);
    }

    private static int calculateScore(ArrayList<Card> hand) {
        int score = 0;
        int aces = 0;
        for (Card card : hand) {
            if (card.getRank().equals("A")) {
                aces++;
                score += 11;
            } else {
                score += card.getValue();
            }
        }
        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }
        return score;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long msec) {
        try {
            Thread.sleep(msec);
        } catch (Exception e) {
        }
    }
}