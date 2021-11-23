import javax.swing.SwingUtilities;


public class Uruchom {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // lambda - arrow function, implementacja Runnable()
            // Okno1 okno1 = new Okno1();
            // new Okno1().setVisible(true);

            Macierz macierzUruchom = new Macierz();
            new Macierz().setVisible(true);
            }
        );
    }
}