import javax.swing.JFrame;

public class Application extends JFrame {

    public Application() {
        add(new Board());
        pack();

        setTitle("Part A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setVisible(true);
    }
}