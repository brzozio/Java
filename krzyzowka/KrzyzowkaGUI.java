import javax.swing.BorderFactory;
import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class KrzyzowkaGUI extends JFrame{
    KrzyzowkaGUI[][] krzyzowkaGUI = new KrzyzowkaGUI[4][9];
   //JTextField[] textFields = new JTextField[10];
    
   KrzyzowkaGUI(){
        Krzyzowka krzyzoweczka = new Krzyzowka();
        setTitle("KRZYZOWECZKA");
        setSize(420,420);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(krzyzoweczka.haslo.length(), 9));
        Container containerTextField = new Container();
            add(containerTextField);

        for(int i = 0; i < krzyzoweczka.haslo.length(); i++){
            char nmbr = (char)(i+48);
            String tempNumber = "" + nmbr;
            JLabel numerPytania = new JLabel(tempNumber);
                add(numerPytania);
            for(int j = 0; j < 9; j++){
                if(krzyzoweczka.krzyzowka[i][j] == 0){
                    JTextField textfield = new JTextField();
                    containerTextField.add(textfield);
                    textfield.setBorder(BorderFactory.createEtchedBorder());
                    if(j==5){ // wyroznienie kolorem zielonym pól z hasłem
                        textfield.setBackground(Color.green);
                    }
                }else {
                    JLabel label = new JLabel();
                    add(label);
                    label.setVisible(false);
                }
            }
        }

        JTextArea textArea = new JTextArea();
            add(textArea);
            JScrollPane scroll = new JScrollPane(textArea);
            add(scroll);
            
        String[] temp = krzyzoweczka.dajPytanie();
        for(int i = 0; i < krzyzoweczka.haslo.length(); i++){
            textArea.append(temp[i]);
        }
        
        pack();
   }
}
