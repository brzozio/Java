import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SudokuWindow extends JFrame implements FieldValueChangeListener {
    public List<String> puzzle;
    private JButton SudokuWindow[][] = new JButton[9][9];


    
    public SudokuWindow(){ // konstuktor
        this.readPuzzle();
        this.createGui();
    }

    public void readPuzzle(){
        try{
            puzzle = Files.readAllLines(Paths.get("puzzle.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createGui(){
        setVisible(true);
        setSize(500,500);
        int pobieranaLiczba = 0;
        setLayout(new GridLayout(9,9));
        int[][] tablicaGui = new int[9][9];

        for(int wiersz = 0; wiersz < 9; wiersz++){
            for(int kolumna = 0; kolumna < 9; kolumna++){
                SudokuWindow[wiersz][kolumna] = new JButton("");
                add(SudokuWindow[wiersz][kolumna]);
                if(pobieranaLiczba != 0){
                    SudokuWindow[wiersz][kolumna].setEnabled(false);
                    FixedSudokuField pole = new FixedSudokuField();
                }

                if(pobieranaLiczba == 0){
                    SudokuWindow[wiersz][kolumna].setEnabled(true);
                }
            }
        }
    }

    @Override
    public void fieldsChanged(); // metoda z interfejsu FieldValueChangeListener

}
