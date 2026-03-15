
package mow;

public class Mower {
    private int row;
    private int col;

    private int direction;

    public Mower() {
        row = 1;
        col = 1;
        direction = 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        col = c;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int d) {
        direction = d;
    }

    public char getDirectionSymbol() {
        if (direction == 0) return '^';
        if (direction == 1) return '>';
        if (direction == 2) return 'v';
        return '<';
    }

    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    public void moveForward() {
        if (direction == 0) {
            row--;
        } else if (direction == 1) {
            col++;
        } else if (direction == 2) {
            row++;
        } else {
            col--;
        }
    }

    public void cutGrass(Yard yard) {
        yard.setCell(row, col, ' ');
    }

    public char senseFront(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        if (direction == 0) {
            nextRow--;
        } else if (direction == 1) {
            nextCol++;
        } else if (direction == 2) {
            nextRow++;
        } else {
            nextCol--;
        }

        return yard.getCell(nextRow, nextCol);
    }

    public char senseRight(Yard yard) {
        int rightDir = (direction + 1) % 4;
        int nextRow = row;
        int nextCol = col;

        if (rightDir == 0) {
            nextRow--;
        } else if (rightDir == 1) {
            nextCol++;
        } else if (rightDir == 2) {
            nextRow++;
        } else {
            nextCol--;
        }

        return yard.getCell(nextRow, nextCol);
    }

    public char senseLeft(Yard yard) {
        int leftDir = (direction + 3) % 4;
        int nextRow = row;
        int nextCol = col;

        if (leftDir == 0) {
            nextRow--;
        } else if (leftDir == 1) {
            nextCol++;
        } else if (leftDir == 2) {
            nextRow++;
        } else {
            nextCol--;
        }

        return yard.getCell(nextRow, nextCol);
    }

    public void randomizePosition(Yard yard) {
        int height = yard.getHeight();
        int width = yard.getWidth();

        int corner = (int)(Math.random() * 4);

        if (corner == 0) {         
            row = 1;
            col = 1;
        } else if (corner == 1) {   
            row = 1;
            col = width;
        } else if (corner == 2) {  
            row = height;
            col = 1;
        } else {                   
            row = height;
            col = width;
        }

        direction = (int)(Math.random() * 4);
    }

    public boolean updateMower(Yard yard) {
        cutGrass(yard);

        if (!yard.hasUnmowedGrass()) {
            return false;
        }

        if (senseFront(yard) == '+') {
            moveForward();
            cutGrass(yard);
            return true;
        }

        if (senseRight(yard) == '+') {
            turnRight();
            moveForward();
            cutGrass(yard);
            return true;
        }

        if (senseLeft(yard) == '+') {
            turnLeft();
            moveForward();
            cutGrass(yard);
            return true;
        }

        turnRight();
        turnRight();

        if (senseFront(yard) != 'R') {
            moveForward();
            cutGrass(yard);
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (senseFront(yard) != 'R') {
                moveForward();
                cutGrass(yard);
                return true;
            }
            turnRight();
        }

        return false;
    }
}