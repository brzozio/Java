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

public class Okno2 extends JFrame {
    Okno2(){
        setTitle("Drugie okno");
        setSize(420,420);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton buttonSuma = new JButton("SUMA");
            add(buttonSuma);

        ActionListener suma = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent arg0){
                JOptionPane.showMessageDialog(Okno2.this, "");
             }
         }; 
            buttonSuma.addActionListener(suma);

        pack();
    }
}