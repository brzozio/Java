import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;

public class SudokuWindow extends JFrame implements FieldValueChangeListener {
    
    public SudokuWindow(){ // konstuktor
        this.readPuzzle();
        this.createGui();
    }

    public void readPuzzle(){
        try{
            List<String> puzzle = Files.readAllLines(Paths.get("puzzle.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createGui(){

        setSize(500,500);
    }

    @Override
    public void fieldsChanged(){

    }

}
