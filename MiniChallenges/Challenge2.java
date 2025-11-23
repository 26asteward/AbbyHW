public class Challenge2 {

    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        while (true) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            
            System.out.println("You rolled:");
            printDie(die1);
            printDie(die2);
            
            if (die1 == die2) {
                System.out.println("Both dice are the same! Ending the game.");
                break;
            } else {
                System.out.print("Press play to roll again or any other key to exit: ");
                String userInput = scanner.nextLine();
                if (!userInput.equalsIgnoreCase("play")) {
                    System.out.println("Exiting the game. Goodbye!");
                    break;

            }
        }
        
        scanner.close();
    }
    }
    
    private static void printDie(int number) {
        String[] dieFaces = {
            "+-------+\n|       |\n|   O   |\n|       |\n+-------+",
            "+-------+\n| O     |\n|       |\n|     O |\n+-------+",
            "+-------+\n| O     |\n|   O   |\n|     O |\n+-------+",
            "+-------+\n| O   O |\n|       |\n| O   O |\n+-------+",
            "+-------+\n| O   O |\n|   O   |\n| O   O |\n+-------+",
            "+-------+\n| O   O |\n| O   O |\n| O   O |\n+-------+"
        };
        
        System.out.println(dieFaces[number - 1]);
    }
}
