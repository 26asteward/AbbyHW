import javax.swing.*;
import java.awt.*;

public class PartB extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int tileSize = 100;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if ((row + col) % 2 == 0)
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.BLUE);

                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkerboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 440);
        frame.add(new PartB());
        frame.setVisible(true);
    }
}

