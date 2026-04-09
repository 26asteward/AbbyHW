import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class GraphicsTemplate {

    public static void draw(Graphics g) {
        g.setColor(new Color(25, 25, 112));
        g.fillRect(0, 0, 400, 400);

        g.setColor(Color.WHITE);
        int[] starX = { 40, 120, 220, 310, 360, 80, 180, 280 };
        int[] starY = { 40, 70, 120, 90, 50, 200, 180, 240 };
        for (int i = 0; i < starX.length; i++) {
            g.fillOval(starX[i], starY[i], 4, 4);
        }

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(170, 150, 60, 150);
        g.setColor(Color.GRAY);
        g.drawRect(170, 150, 60, 150);

        g.setColor(Color.RED);
        int[] noseX = { 170, 200, 230 };
        int[] noseY = { 150, 90, 150 };
        g.fillPolygon(noseX, noseY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(noseX, noseY, 3);

        g.setColor(Color.RED);
        int[] leftFinX = { 170, 130, 170 };
        int[] leftFinY = { 260, 290, 290 };
        int[] rightFinX = { 230, 270, 230 };
        int[] rightFinY = { 260, 290, 290 };
        g.fillPolygon(leftFinX, leftFinY, 3);
        g.fillPolygon(rightFinX, rightFinY, 3);

        g.setColor(Color.CYAN);
        g.fillOval(185, 190, 30, 30);
        g.setColor(Color.BLUE);
        g.drawOval(185, 190, 30, 30);

        g.setColor(Color.ORANGE);
        int[] flameX = { 180, 200, 220 };
        int[] flameY = { 300, 340, 300 };
        g.fillPolygon(flameX, flameY, 3);
        g.setColor(Color.YELLOW);
        int[] innerFlameX = { 190, 200, 210 };
        int[] innerFlameY = { 300, 330, 300 };
        g.fillPolygon(innerFlameX, innerFlameY, 3);
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }


    public static void main(String[] args) {
        
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

       
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Graphics Template");

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}