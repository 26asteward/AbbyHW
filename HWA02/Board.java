import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;

    private BufferedImage img;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        try {
            File imageFile = new File("media/images.jpeg/image.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println("Could not load image: " + e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            int boardWidth = getWidth();
            int boardHeight = getHeight();

            double scaleX = (boardWidth / 2.0) / img.getWidth();
            double scaleY = (boardHeight / 2.0) / img.getHeight();
            double scale = Math.min(scaleX, scaleY);

            int scaledWidth = (int) (img.getWidth() * scale);
            int scaledHeight = (int) (img.getHeight() * scale);

            int x = boardWidth - scaledWidth;
            int y = boardHeight - scaledHeight;

            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.scale(scale, scale);

            g2d.drawImage(img, at, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }
}
