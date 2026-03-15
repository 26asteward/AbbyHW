package mow;

public class Yard {
    private char[][] yard;

    private int lawnHeight;
    private int lawnWidth;

    public Yard(int height, int width) {
        lawnHeight = height;
        lawnWidth = width;

        yard = new char[height + 2][width + 2];

        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[0].length; c++) {
                if (r == 0 || r == yard.length - 1 || c == 0 || c == yard[0].length - 1) {
                    yard[r][c] = 'R';
                } else {
                    yard[r][c] = '+';
                }
            }
        }
    }

    public char getCell(int row, int col) {
        return yard[row][col];
    }

    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    public int getHeight() {
        return lawnHeight;
    }

    public int getWidth() {
        return lawnWidth;
    }

    public void printYard() {
        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[0].length; c++) {
                System.out.print(yard[r][c]);
            }
            System.out.println();
        }
    }

    public void printYard(Mower mower) {
        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[0].length; c++) {
                if (mower != null && r == mower.getRow() && c == mower.getCol()) {
                    System.out.print(mower.getDirectionSymbol());
                } else {
                    System.out.print(yard[r][c]);
                }
            }
            System.out.println();
        }
    }

    public boolean hasUnmowedGrass() {
        for (int r = 1; r <= lawnHeight; r++) {
            for (int c = 1; c <= lawnWidth; c++) {
                if (yard[r][c] == '+') {
                    return true;
                }
            }
        }
        return false;
    }
}