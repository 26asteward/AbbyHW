import javax.swing.JFrame;

public class ApplicationPartB extends JFrame {

    public ApplicationPartB() {
        add(new BoardPartB());
        pack();

        setTitle("AT Animation Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        ApplicationPartB app = new ApplicationPartB();
        app.setVisible(true);
    }
}