import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PartA extends JPanel {

    public PartA() {
        setPreferredSize(new Dimension(350, 350));
    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.BLUE);
        g2.setFont(new Font("Arial", Font.BOLD, 18));
        g2.drawString("Hello, world!", 20, 30);
        
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 150, 150);

        AffineTransform at = new AffineTransform();

        double centerX = getWidth() / 2.0;   
        double centerY = getHeight() / 2.0;  

        at.translate(centerX - 75, centerY - 75);

        at.rotate(-Math.PI / 8, 75, 75);

        Shape transformedRect = at.createTransformedShape(rect);

        g2.setColor(Color.MAGENTA);
        g2.fill(transformedRect);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PartA());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}