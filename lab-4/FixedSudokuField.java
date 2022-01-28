import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class FixedSudokuField extends SudokuField {
    public FixedSudokuField(int value, final FieldValueChangeListener listener) {
        super(value);
        super.setDisplayedValue(value);
        //super.setBackground(Color.green);
    }
}
