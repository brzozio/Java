public class FixedSudokuField extends SudokuField {
    
    public FixedSudokuField(int value, final FieldValueChangeListener listener) {
        super(value);
        super.setDisplayedValue(value);
    }
}
