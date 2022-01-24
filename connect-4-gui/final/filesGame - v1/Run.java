package filesGame;
import javax.swing.SwingUtilities;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gra gra = new Gra();
            new Gra().setVisible(true);
        });
    }
}
