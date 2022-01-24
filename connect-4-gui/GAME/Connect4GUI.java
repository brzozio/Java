import javax.swing.JFrame;

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
        gra.GameStateListener
		gra.zerujTablice();
        this.createGUI();
    }

    public void createGUI(){

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
}
