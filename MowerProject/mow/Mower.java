package mow;

import java.util.Random;

public class Mower {
    private static final Random RANDOM = new Random();
    private static final int[] ROW_DELTAS = {-1, 0, 1, 0};
    private static final int[] COL_DELTAS = {0, 1, 0, -1};
    private static final char[] DIRECTION_SYMBOLS = {'^', '>', 'v', '<'};

    private int row;
    private int column;
    private int direction;

    public Mower() {
        this.direction = 0;
    }

    public void randomize(Yard yard) {
        int height = yard.getHeight();
        int width = yard.getWidth();

        int corner = RANDOM.nextInt(4);
        switch (corner) {
            case 0 -> {
                row = 1;
                column = 1;
            }
            case 1 -> {
                row = 1;
                column = width;
            }
            case 2 -> {
                row = height;
                column = 1;
            }
            default -> {
                row = height;
                column = width;
            }
        }

        direction = RANDOM.nextInt(4);
    }

    public boolean updateMower(Yard yard) {
        if (!hasUnmowed(yard)) {
            return false;
        }

        if (yard.getCell(row, column) == '+') {
            yard.setCell(row, column, ' ');
        }

        int nextDirection = chooseNextDirection(yard);
        if (nextDirection < 0) {
            return false;
        }

        direction = nextDirection;
        row += ROW_DELTAS[direction];
        column += COL_DELTAS[direction];
        return true;
    }

    private int chooseNextDirection(Yard yard) {
        int front = direction;
        int right = (direction + 1) % 4;
        int left = (direction + 3) % 4;
        int back = (direction + 2) % 4;
        int[] searchOrder = {front, right, left, back};

        for (int candidate : searchOrder) {
            int nextRow = row + ROW_DELTAS[candidate];
            int nextCol = column + COL_DELTAS[candidate];
            if (isUnmowed(yard, nextRow, nextCol)) {
                return candidate;
            }
        }

        for (int candidate : searchOrder) {
            int nextRow = row + ROW_DELTAS[candidate];
            int nextCol = column + COL_DELTAS[candidate];
            if (isMovable(yard, nextRow, nextCol)) {
                return candidate;
            }
        }

        return -1;
    }

    private boolean hasUnmowed(Yard yard) {
        for (int r = 1; r <= yard.getHeight(); r++) {
            for (int c = 1; c <= yard.getWidth(); c++) {
                if (yard.getCell(r, c) == '+') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInside(Yard yard, int row, int column) {
        return row >= 0 && row < yard.yard.length && column >= 0 && column < yard.yard[0].length;
    }

    private boolean isMovable(Yard yard, int row, int column) {
        return isInside(yard, row, column) && yard.getCell(row, column) != 'R';
    }

    private boolean isUnmowed(Yard yard, int row, int column) {
        return isInside(yard, row, column) && yard.getCell(row, column) == '+';
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirectionSymbol() {
        return DIRECTION_SYMBOLS[direction];
    }
}
