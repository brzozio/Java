import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

public class Okno1 extends JFrame {
    Okno1(){
        setTitle("Pierwsze okno");
        setSize(420,420);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel imie = new JLabel("Imie");
            add(imie);
        JTextField imieText = new JTextField(10);
            add(imieText);

        JLabel kierunek = new JLabel("Imie");
            add(kierunek);
        JTextField kierunekText = new JTextField(10);
            add(kierunekText);

        JButton button = new JButton("Pokaż");
            add(button);

        ActionListener event = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent arg0){
                String imieShow = imieText.getText();
                String kierunekShow = kierunekText.getText();
                JOptionPane.showMessageDialog(Okno1.this, "Cześć " + imieShow + " studiujacy na kierunku " + kierunekShow);
             }
         }; 
            button.addActionListener(event);

        pack();
    }
}