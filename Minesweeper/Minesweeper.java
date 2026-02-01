import java.util.Scanner;
import java.util.Random;

public class Minesweeper {
    private static final int BOARD_SIZE = 9;
    private static final int NUM_MINES = 10;
    
    private char[][] map;           
    private char[][] board;        
    private boolean gameOver;
    private boolean gameWon;
    private int revealedCount;      
    
    public Minesweeper() {
        map = new char[BOARD_SIZE][BOARD_SIZE];
        board = new char[BOARD_SIZE][BOARD_SIZE];
        gameOver = false;
        gameWon = false;
        revealedCount = 0;
        
        initializeMap();
        initializeBoard();
    }
    
   
    private void initializeMap() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                map[i][j] = ' ';
            }
        }
        
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < NUM_MINES) {
            int row = rand.nextInt(BOARD_SIZE);
            int col = rand.nextInt(BOARD_SIZE);
            
            if (map[row][col] != 'b') {
                map[row][col] = 'b';
                minesPlaced++;
            }
        }
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (map[i][j] != 'b') {
                    int count = countAdjacentMines(i, j);
                    if (count > 0) {
                        map[i][j] = (char) ('0' + count);
                    }
                }
            }
        }
    }
    
  
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '#';
            }
        }
    }
 
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < BOARD_SIZE && j >= 0 && j < BOARD_SIZE) {
                    if (map[i][j] == 'b') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    

    public void revealTile(int row, int col) {
        if (!isValidPosition(row, col)) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (board[row][col] != '#') {
            System.out.println("Tile already revealed or flagged!");
            return;
        }
        
        if (map[row][col] == 'b') {
            board[row][col] = 'm';
            gameOver = true;
        } else {
            board[row][col] = map[row][col];
            revealedCount++;
            
            if (revealedCount == BOARD_SIZE * BOARD_SIZE - NUM_MINES) {
                gameWon = true;
                gameOver = true;
            }
        }
    }
    
  
    public void toggleFlag(int row, int col) {
        if (!isValidPosition(row, col)) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (board[row][col] == '#') {
            board[row][col] = 'f';
        } else if (board[row][col] == 'f') {
            board[row][col] = '#';
        } else {
            System.out.println("Cannot flag an already revealed tile!");
        }
    }
    
   
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }
    
  
    public void displayBoard() {
        System.out.println("\n   0 1 2 3 4 5 6 7 8");
        System.out.println("  +---+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+---+");
        }
        System.out.println();
    }
    
   
    public void displayMap() {
        System.out.println("\n   0 1 2 3 4 5 6 7 8 (MAP - CHEAT MODE)");
        System.out.println("  +---+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" " + map[i][j] + " |");
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+---+");
        }
        System.out.println();
    }
    
  
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
   
    public void play() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Commands: R row col (reveal), F row col (flag), C (cheat), Q (quit)");
        
        while (!gameOver) {
            displayBoard();
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.isEmpty()) {
                continue;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            
            if (command.equals("Q")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (command.equals("C")) {
                clearScreen();
                displayMap();
            } else if (command.equals("R")) {
                if (parts.length < 3) {
                    System.out.println("Usage: R row col");
                    continue;
                }
                try {
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    revealTile(row, col);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter valid row and column numbers.");
                }
            } else if (command.equals("F")) {
                if (parts.length < 3) {
                    System.out.println("Usage: F row col");
                    continue;
                }
                try {
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    toggleFlag(row, col);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter valid row and column numbers.");
                }
            } else {
                System.out.println("Invalid command. Use R (reveal), F (flag), C (cheat), or Q (quit).");
            }
        }
        
        displayBoard();
        if (gameWon) {
            System.out.println("Congratulations! You won the game!");
        } else if (!gameWon && gameOver) {
            System.out.println("Game Over! You hit a mine!");
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.play();
    }
}
