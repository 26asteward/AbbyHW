import javax.swing.*;
import java.awt.*;

public class PartC extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);

        double scale = 150.0;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int steps = 1000;

        int prevX = 0, prevY = 0;
        for (int i = 0; i <= steps; i++) {
            double theta = 2 * Math.PI * i / steps;
            double r = Math.cos(2 * theta);
            double x = scale * r * Math.cos(theta);
            double y = scale * r * Math.sin(theta);

            int plotX = (int) (centerX + x);
            int plotY = (int) (centerY - y); 

            if (i > 0)
                g2.drawLine(prevX, prevY, plotX, plotY);

            prevX = plotX;
            prevY = plotY;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Four-Leaved Rose");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new PartC());
        frame.setBackground(Color.PINK);
        frame.setVisible(true);
    }
}


