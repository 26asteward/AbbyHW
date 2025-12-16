import javax.swing.*;
import java.awt.*;

public class PartA extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.YELLOW);
        g2.fillOval(50, 50, 200, 200);

        g2.setColor(Color.BLACK);
        g2.fillOval(100, 100, 25, 25);
        g2.fillOval(175, 100, 25, 25);

        g2.drawLine(100, 200, 200, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smiley Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new PartA());
        frame.setVisible(true);
    }
}
