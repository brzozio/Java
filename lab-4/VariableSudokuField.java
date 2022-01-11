import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class VariableSudokuField extends SudokuField{
    public VariableSudokuField(final FieldValueChangeListener listener){
        SudokuField sudokuFieldkk = new SudokuField(0);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem mi;

        popupMenu.add(mi = new JMenuItem("Wyczysc"));

        mi.addActionListener(e->{
            listener.fieldsChanged();
        });

        // pozostale polecenia menu
    }

    @Override
    public void setValue(int value){
        
    }
}
