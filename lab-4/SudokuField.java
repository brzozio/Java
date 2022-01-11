import javax.swing.JLabel;

public class SudokuField extends JLabel{
    private int value;

    public SudokuField(int value){
        this.setSudokuField();
    }

    protected void getSudokuField();
    protected void setSudokuField();

    protected void setDisplayedValue(){
        if(this.value != 0){

        }
    }
}
