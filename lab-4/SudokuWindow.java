import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SudokuWindow extends JFrame implements FieldValueChangeListener {
    public List<String> puzzle;
    // private JButton SudokuWindow[][] = new JButton[9][9];
    SudokuField[][] tablicaGui = new SudokuField[9][9];
    String[] linia = new String[9];

    
    public SudokuWindow(){ // konstuktor
        readPuzzle();
        createGui();
       // showList();
        
    }

    public void showList(){ // do testowania
        for(int i = 0; i < 9; i++){
                System.out.print(puzzle.get(i));
                System.out.print("\n");
        }
    }

    public void readPuzzle(){
        try{
            File file = new File("puzzle2.txt");
            URI fileUri = file.toURI();
            Path puzzlePath = Paths.get(fileUri);
            puzzle = Files.readAllLines(puzzlePath);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createGui(){
        setTitle("Sudoku");
        setVisible(true);
        setSize(500,500);
        setLayout(new GridLayout(9,9));
        for(int i = 0; i < 9; i++){ // wpisywanie linii do tablicy linii
            linia[i] = puzzle.get(i);
            System.out.print(linia[i]);
        }

        for(int wiersz = 0; wiersz < 9; wiersz++){
            for(int kolumna = 0; kolumna < 9; kolumna++){
                if( linia[wiersz].charAt(kolumna) == '0'){
                    VariableSudokuField fieldV = new VariableSudokuField(this);
                    tablicaGui[wiersz][kolumna] = fieldV; 
                        add(fieldV.label);
                }else if(linia[wiersz].charAt(kolumna) == '1' ||
                    linia[wiersz].charAt(kolumna) == '2' ||
                    linia[wiersz].charAt(kolumna) == '3' ||
                    linia[wiersz].charAt(kolumna) == '4' ||
                    linia[wiersz].charAt(kolumna) == '5' ||
                    linia[wiersz].charAt(kolumna) == '6' ||
                    linia[wiersz].charAt(kolumna) == '7' ||
                    linia[wiersz].charAt(kolumna) == '8' ||
                    linia[wiersz].charAt(kolumna) == '9'){
                        int puzzleInt = linia[wiersz].charAt(kolumna) - 48;
                        FixedSudokuField fieldF = new FixedSudokuField(puzzleInt,this);
                        tablicaGui[wiersz][kolumna] = fieldF;
                            add(fieldF.label);
                }
                System.out.print(linia[wiersz].charAt(kolumna)); 
            }
        }
}

    @Override
    public void fieldsChanged(){ // metoda z interfejsu FieldValueChangeListener
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                tablicaGui[i][j].setError(false);
            }
        }

        // sprawdzanie wierszy
        for(int i = 0; i < 9; i++){
            int j = 8;
            if(tablicaGui[i][j-8] == tablicaGui[i][j-7] || tablicaGui[i][j-8] == tablicaGui[i][j-6] 
                || tablicaGui[i][j-8] == tablicaGui[i][j-5] || tablicaGui[i][j-8] == tablicaGui[i][j-4] 
                || tablicaGui[i][j-8] == tablicaGui[i][j-3] || tablicaGui[i][j-8] == tablicaGui[i][j-2] 
                || tablicaGui[i][j-8] == tablicaGui[i][j-1] || tablicaGui[i][j-8] == tablicaGui[i][j-0]
                || tablicaGui[i][j-7] == tablicaGui[i][j-6] || tablicaGui[i][j-7] == tablicaGui[i][j-5] 
                || tablicaGui[i][j-7] == tablicaGui[i][j-4] || tablicaGui[i][j-7] == tablicaGui[i][j-3] 
                || tablicaGui[i][j-7] == tablicaGui[i][j-2] || tablicaGui[i][j-7] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-7] == tablicaGui[i][j-0]
                || tablicaGui[i][j-6] == tablicaGui[i][j-5] 
                || tablicaGui[i][j-6] == tablicaGui[i][j-4] || tablicaGui[i][j-6] == tablicaGui[i][j-3] 
                || tablicaGui[i][j-6] == tablicaGui[i][j-2] || tablicaGui[i][j-6] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-6] == tablicaGui[i][j-0]
                || tablicaGui[i][j-5] == tablicaGui[i][j-4] || tablicaGui[i][j-5] == tablicaGui[i][j-3] 
                || tablicaGui[i][j-5] == tablicaGui[i][j-2] || tablicaGui[i][j-5] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-5] == tablicaGui[i][j-0]
                || tablicaGui[i][j-4] == tablicaGui[i][j-3] || tablicaGui[i][j-4] == tablicaGui[i][j-2] 
                || tablicaGui[i][j-4] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-4] == tablicaGui[i][j-0] || tablicaGui[i][j-3] == tablicaGui[i][j-2] 
                || tablicaGui[i][j-3] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-3] == tablicaGui[i][j-0]
                || tablicaGui[i][j-2] == tablicaGui[i][j-1] 
                || tablicaGui[i][j-2] == tablicaGui[i][j-0]
                || tablicaGui[i][j-1] == tablicaGui[i][j-0]){
                    for(int w = 0; w < 9; w++){
                        tablicaGui[i][w].setError(true); // zaznaczanie bledu wiersza
                    }
            }
        }

        // sprawdzanie kolumn
        for(int kolumna = 0; kolumna < 9; kolumna++){
            int wiersz = 8;
            if(tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-5][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-4][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-3][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-2][kolumna] ||
                   tablicaGui[wiersz][kolumna] == tablicaGui[wiersz-1][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-5][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-4][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-3][kolumna] ||
                   tablicaGui[wiersz-1][kolumna] == tablicaGui[wiersz-2][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-5][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-4][kolumna] ||
                   tablicaGui[wiersz-2][kolumna] == tablicaGui[wiersz-3][kolumna] ||
                   tablicaGui[wiersz-3][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-3][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-3][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz-3][kolumna] == tablicaGui[wiersz-5][kolumna] ||
                   tablicaGui[wiersz-3][kolumna] == tablicaGui[wiersz-4][kolumna] ||
                   tablicaGui[wiersz-4][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-4][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-4][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz-4][kolumna] == tablicaGui[wiersz-5][kolumna] ||
                   tablicaGui[wiersz-5][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-5][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-5][kolumna] == tablicaGui[wiersz-6][kolumna] ||
                   tablicaGui[wiersz-6][kolumna] == tablicaGui[wiersz-8][kolumna] ||
                   tablicaGui[wiersz-6][kolumna] == tablicaGui[wiersz-7][kolumna] ||
                   tablicaGui[wiersz-7][kolumna] == tablicaGui[wiersz-8][kolumna]
                  ){
                    for(int w = 0; w < 9; w++){
                        tablicaGui[w][kolumna].setError(true); // zaznaczanie bledu kolumny
                    }
                }
            }
        

        // zaznaczanie kwadratu 3x3
            for(int kwadrat = 0; kwadrat < 7; kwadrat+=3){ // kwadraty po lewo
                for(int innerRow = 0+kwadrat; innerRow < 3+kwadrat; innerRow++){
                    if(tablicaGui[innerRow][2] == tablicaGui[innerRow][1] || tablicaGui[innerRow][2] == tablicaGui[innerRow][0] ||
                       tablicaGui[innerRow][1] == tablicaGui[innerRow][0]){ // sprawdzanie wiersza w kwadracie
                           for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                               for(int kolumna = 0; kolumna < 3; kolumna++){
                                   tablicaGui[wiersz][kolumna].setError(true);
                               }
                           }
                    }else if(tablicaGui[0+kwadrat][2] == tablicaGui[1+kwadrat][2] || 
                    tablicaGui[0+kwadrat][2] == tablicaGui[2+kwadrat][2] ||
                    tablicaGui[2+kwadrat][2] == tablicaGui[1+kwadrat][2] || 
                    tablicaGui[0+kwadrat][1] == tablicaGui[1+kwadrat][1] || 
                    tablicaGui[0+kwadrat][1] == tablicaGui[2+kwadrat][1] ||
                    tablicaGui[2+kwadrat][1] == tablicaGui[1+kwadrat][1] ||
                    tablicaGui[0+kwadrat][0] == tablicaGui[1+kwadrat][0] || 
                    tablicaGui[0+kwadrat][0] == tablicaGui[2+kwadrat][0] ||
                    tablicaGui[2+kwadrat][0] == tablicaGui[1+kwadrat][0]){ // sprawdzanie kolumn w kwadracie
                       for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                           for(int kolumna = 0; kolumna < 3; kolumna++){
                               tablicaGui[wiersz][kolumna].setError(true);
                           }
                       }
           }
                }
                if(tablicaGui[0+kwadrat][0] == tablicaGui[1+kwadrat][1] ||
                             tablicaGui[0+kwadrat][0] == tablicaGui[2+kwadrat][2] ||
                             tablicaGui[0+kwadrat][1] == tablicaGui[1+kwadrat][2] ||
                             tablicaGui[1+kwadrat][0] == tablicaGui[2+kwadrat][1] ||
                             tablicaGui[0+kwadrat][2] == tablicaGui[1+kwadrat][1] ||
                             tablicaGui[0+kwadrat][2] == tablicaGui[0+kwadrat][0] ||
                             tablicaGui[0+kwadrat][1] == tablicaGui[1+kwadrat][0] ||
                             tablicaGui[2+kwadrat][2] == tablicaGui[2+kwadrat][1]){ // przekatna
                                for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                                    for(int kolumna = 0; kolumna < 3; kolumna++){
                                        tablicaGui[wiersz][kolumna].setError(true);
                                    }
                                }
                    }
            }

            for(int kwadrat = 0; kwadrat < 7; kwadrat+=3){ // kwadraty po srodku
                for(int innerRow = 0+kwadrat; innerRow < 3+kwadrat; innerRow++){
                    if(tablicaGui[innerRow][5] == tablicaGui[innerRow][4] || tablicaGui[innerRow][5] == tablicaGui[innerRow][3] ||
                       tablicaGui[innerRow][4] == tablicaGui[innerRow][3]){ // sprawdzanie wiersza w kwadracie
                        for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                            for(int kolumna = 3; kolumna < 6; kolumna++){
                                tablicaGui[wiersz][kolumna].setError(true);
                            }
                        }
                    }else if(tablicaGui[0+kwadrat][6] == tablicaGui[1+kwadrat][6] || 
                    tablicaGui[0+kwadrat][6] == tablicaGui[2+kwadrat][6] ||
                    tablicaGui[2+kwadrat][6] == tablicaGui[1+kwadrat][6] || 
                    tablicaGui[0+kwadrat][5] == tablicaGui[1+kwadrat][5] || 
                    tablicaGui[0+kwadrat][5] == tablicaGui[2+kwadrat][5] ||
                    tablicaGui[2+kwadrat][5] == tablicaGui[1+kwadrat][5] ||
                    tablicaGui[0+kwadrat][4] == tablicaGui[1+kwadrat][4] || 
                    tablicaGui[0+kwadrat][4] == tablicaGui[2+kwadrat][4] ||
                    tablicaGui[2+kwadrat][4] == tablicaGui[1+kwadrat][4]){ // sprawdzanie kolumn w kwadracie
                       for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                           for(int kolumna = 3; kolumna < 6; kolumna++){
                               tablicaGui[wiersz][kolumna].setError(true);
                           }
                       }
           }
                }
                if(tablicaGui[0+kwadrat][3] == tablicaGui[1+kwadrat][4] ||
                             tablicaGui[0+kwadrat][3] == tablicaGui[2+kwadrat][5] ||
                             tablicaGui[0+kwadrat][4] == tablicaGui[1+kwadrat][5] ||
                             tablicaGui[1+kwadrat][3] == tablicaGui[2+kwadrat][4] ||
                             tablicaGui[0+kwadrat][5] == tablicaGui[1+kwadrat][4] ||
                             tablicaGui[0+kwadrat][5] == tablicaGui[0+kwadrat][3] ||
                             tablicaGui[0+kwadrat][4] == tablicaGui[1+kwadrat][3] ||
                             tablicaGui[2+kwadrat][5] == tablicaGui[2+kwadrat][4]){ // przekatna
                                for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                                    for(int kolumna = 3; kolumna < 6; kolumna++){
                                        tablicaGui[wiersz][kolumna].setError(true);
                                    }
                                }
                    }
            }

            for(int kwadrat = 0; kwadrat < 7; kwadrat+=3){ // kwadraty po prawo
                for(int innerRow = 0+kwadrat; innerRow < 3+kwadrat; innerRow++){
                    if(tablicaGui[innerRow][8] == tablicaGui[innerRow][7] || tablicaGui[innerRow][8] == tablicaGui[innerRow][6] ||
                       tablicaGui[innerRow][7] == tablicaGui[innerRow][6]){ // sprawdzanie wiersza w kwadracie
                        for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                            for(int kolumna = 6; kolumna < 9; kolumna++){
                                tablicaGui[wiersz][kolumna].setError(true);
                            }
                        }
                    }else if(tablicaGui[0+kwadrat][8] == tablicaGui[1+kwadrat][8] || 
                             tablicaGui[0+kwadrat][8] == tablicaGui[2+kwadrat][8] ||
                             tablicaGui[2+kwadrat][8] == tablicaGui[1+kwadrat][8] || 
                             tablicaGui[0+kwadrat][7] == tablicaGui[1+kwadrat][7] || 
                             tablicaGui[0+kwadrat][7] == tablicaGui[2+kwadrat][7] ||
                             tablicaGui[2+kwadrat][7] == tablicaGui[1+kwadrat][7] ||
                             tablicaGui[0+kwadrat][6] == tablicaGui[1+kwadrat][6] || 
                             tablicaGui[0+kwadrat][6] == tablicaGui[2+kwadrat][6] ||
                             tablicaGui[2+kwadrat][6] == tablicaGui[1+kwadrat][6]){ // sprawdzanie kolumn w kwadracie
                                for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                                    for(int kolumna = 6; kolumna < 9; kolumna++){
                                        tablicaGui[wiersz][kolumna].setError(true);
                                    }
                                }
                    }
                }
                if(tablicaGui[0+kwadrat][3] == tablicaGui[1+kwadrat][4] ||
                             tablicaGui[0+kwadrat][6] == tablicaGui[2+kwadrat][8] ||
                             tablicaGui[0+kwadrat][7] == tablicaGui[1+kwadrat][8] ||
                             tablicaGui[1+kwadrat][6] == tablicaGui[2+kwadrat][7] ||
                             tablicaGui[0+kwadrat][8] == tablicaGui[1+kwadrat][7] ||
                             tablicaGui[0+kwadrat][8] == tablicaGui[0+kwadrat][6] ||
                             tablicaGui[0+kwadrat][7] == tablicaGui[1+kwadrat][6] ||
                             tablicaGui[2+kwadrat][8] == tablicaGui[2+kwadrat][7]){ // przekatna
                                for(int wiersz = 0+kwadrat; wiersz < 3+kwadrat; wiersz++){
                                    for(int kolumna = 6; kolumna < 9; kolumna++){
                                        tablicaGui[wiersz][kolumna].setError(true);
                                    }
                                }
                    }
            }
    } 

}
