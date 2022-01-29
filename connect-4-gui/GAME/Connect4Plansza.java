import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.security.GeneralSecurityException;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

public class Connect4Plansza extends JPanel {
    private ColumnClickListener columnClickListener;
    JLabel[][] tablicaLabel = new JLabel[6][7];
    public Connect4Plansza(final Connect4 gra) {
        Connect4 giera = gra;
        setLayout(new GridLayout(6,7));
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                JLabel labelka = new JLabel();
                add(labelka);
                tablicaLabel[i][j] = labelka;
            }
        }
        // dla każdego zarejestrować odbiornik MouseInputAdapter
        // w mouseClicked() wywołać makeMove()
// w mouseEntered() i mouseExited() wywołać odpowiednio selectColumn(..., true) lub selectColumn( …, false)
}
protected void selectColumn(int column, boolean select) {
// zmienić tło - zaznaczyć lub odznaczyć całą kolumnę pól
}

protected void makeMove(int columnNumber) {
        // wywołać columnClicked() odpowiedniego odbiornika
}
public void aktualizuj() {
        // korzystąc z metody dajWartosc(wiersz, kolumna ) zaktualizować zawartość etykiet
}
public void setColumnClickListener(ColumnClickListener listener) {
        this.columnClickListener = listener;
}
}


