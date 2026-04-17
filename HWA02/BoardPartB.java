import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPartB extends JPanel {

    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;

    private BufferedImage img;

    private double x;
    private double y;

    private final double xSpeed = 1;
    private final double ySpeed = 1;

    private double angle = 0;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    public BoardPartB() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        try {
            File imageFile = new File("media/images.jpeg/Andy.png");
            System.out.println("Attempting to load: " + imageFile.getAbsolutePath());
            System.out.println("File exists: " + imageFile.exists());
            img = ImageIO.read(imageFile);

            x = 0;
            y = 0; 
        } catch (Exception e) {
            System.err.println("Could not load image: " + e.getMessage());
            e.printStackTrace();
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITIAL_DELAY, PERIOD_INTERVAL);
    }

    private class ScheduledUpdate extends TimerTask {
        @Override
        public void run() {
            x += xSpeed;
            y += ySpeed;

            angle += 5;

            if (img != null) {
                // Wrap around when image center goes out of bounds
                if (x > B_WIDTH) {
                    x = 0;
                }

                if (y > B_HEIGHT) {
                    y = 0;
                }
            }

            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            double halfW = img.getWidth() / 2.0;
            double halfH = img.getHeight() / 2.0;

            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.rotate(Math.toRadians(angle));
            at.translate(-halfW, -halfH);

            g2d.drawImage(img, at, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }
}