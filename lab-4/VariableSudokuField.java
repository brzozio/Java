import java.awt.event.MouseListener;
import java.sql.Time;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class VariableSudokuField extends SudokuField{
    public VariableSudokuField(final FieldValueChangeListener listener){
        super(0);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem mi;

        label.setBorder(BorderFactory.createEtchedBorder());

        popupMenu.add(mi = new JMenuItem("Wyczysc"));
        popupMenu.add(mi = new JMenuItem("1"));
        popupMenu.add(mi = new JMenuItem("2"));
        popupMenu.add(mi = new JMenuItem("3"));
        popupMenu.add(mi = new JMenuItem("4"));
        popupMenu.add(mi = new JMenuItem("5"));
        popupMenu.add(mi = new JMenuItem("6"));
        popupMenu.add(mi = new JMenuItem("7"));
        popupMenu.add(mi = new JMenuItem("8"));
        popupMenu.add(mi = new JMenuItem("9"));
        
        mi.addActionListener(e->{
            listener.fieldsChanged();
        });
        label.add(mi);

       label.addMouseListener(new MouseAdapter() { // menu sie nie pokazuje, jednakze nic dalej nie mozna zrobic
           @Override
            public void mouseClicked(MouseEvent e){
                VariableSudokuField field = VariableSudokuField.this;
                // popupMenu.show(field,field.getWidth()/2,field.getHeight()/2);
                popupMenu.setVisible(true);
                // tutaj funkcja setValue() dla odpowiedniej labelki
                //popupMenu.setVisible(false);
            }
        });
    }

    //  @Override
    //  public void setValue(int value){
    //      super.setDisplayedValue(value);
    //  }
}
