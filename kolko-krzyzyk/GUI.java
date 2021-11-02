import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JFrame;
import java.awt.GridLayout;

public class GUI extends JFrame{
    private KolkoIKrzyzyk kik;
    private JButton plansza[][] = new JButton[3][3];
    public GUI(KolkoIKrzyzyk kik){
        this.kik = kik;
        createGui();
    }

    public void createGui(){
        setLayout(new GridLayout(3,3));
        for(int w = 0; w < 3; w++){
            for(int k = 0; k < 3; k++){
                plansza[w][k] = new JButton(w+" "+k); // nazwy komorki
                add(plansza[w][k]);
            }
        }
    }
}
