import java.awt.LayoutManager;
import java.security.GeneralSecurityException;
import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

public class Connect4GUI extends JFrame implements ColumnClickListener, GameStateListener {
    //pola
    int column,row,numberOfPlayers;
    public Connect4GUI(int rows, int cols, int numberOfPlayers){
        Connect4 gra = new Connect4();
		if(rows == 0 || cols == 0){
			gra = new Connect4(); // twrorzenie planszy 6x7
		} else{
			gra = new Connect4(rows,cols);
			gra = new Connect4(); // tworzenie i tak planszy 6x7
		} 
		// Zerowanie tablicy przed gra
        GameStateListener listener = Connect4GUI.this;
        gra.zerujTablice();
        this.setSize(600,600);
        this.setLocation(500, 400);
        this.createGUI();
    }

    public void createGUI(){
        setLayout(new FlowLayout());
        Container container = new Container();
            add(container);
            container.setLayout(new BorderLayout());

        if(numberOfPlayers == 2){
            char tempChar = (char) (numberOfPlayers+48);
            String temp = "" + tempChar;
            JLabel label = new JLabel(temp);
            container.add(label,BorderLayout.NORTH); // dodawanie labelki na gorze
        }
        GameStateListener listener = Connect4GUI.this;

    }

    @Override
    public void columnClicked(int column){
    }    
    @Override
    public void gameFinished(int winner){

    }
    @Override
    public void waitingForPlayer(){

    }

    @Override
    public void setGameStateListener() {
        // TODO Auto-generated method stub
        
    }
}
