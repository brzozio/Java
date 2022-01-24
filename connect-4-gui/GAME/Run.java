import javax.swing.SwingUtilities;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // lambda - arrow function, implementacja Runnable()
            Connect4Config config = new Connect4Config();
                new Connect4Config().setVisible(true);
            });
    }
}
