import javax.swing.SwingUtilities;


public class Uruchom {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // lambda - arrow function, implementacja Runnable()
            //  Okno1 okno1 = new Okno1();
            //  new Okno1().setVisible(true);

                //Macierz macierz = new Macierz();
           // new Macierz().setVisible(true);

                Okno2 okno2 = new Okno2();
                new Okno2().setVisible(true);
            }
        );
    }
}