import java.awt.event.MouseListener;

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

        popupMenu.add(mi = new JMenuItem("Wyczysc"));

        mi.addActionListener(e->{
            listener.fieldsChanged();
        });


        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                VariableSudokuField field = VariableSudokuField.this;
                popupMenu.show(field,field.getWidth()/2,field.getHeight()/2);
            }
        });

         
        
   
    }

    // @Override
    // public void setValue(int value){
    //     super.setDisplayedValue(value);
    // }
}
