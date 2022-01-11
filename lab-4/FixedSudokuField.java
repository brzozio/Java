public class FixedSudokuField extends SudokuField {
    public int fixedFieldValue = 0;
    
    SudokuField sudoku = new SudokuField(fixedFieldValue);
    
    sudoku.setDisplayedValue();
}
