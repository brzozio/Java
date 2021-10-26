import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // lambda - arrow function, implementacja Runnable()
                new Okno().setVisible(true);
            }
        );
    }
}
