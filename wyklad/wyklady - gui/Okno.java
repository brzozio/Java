import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout; // GridLayout
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

public class Okno extends JFrame {
    Okno(){
        setTitle("Minecraft 1.17.1");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));
        JButton button = new JButton("Przycisk 1");
            add(button);
        JButton button2 = new JButton("Przycisk 2");
            add(button2);
        JButton button3 = new JButton("Przycisk 3");
            add(button3);

        ActionListener event = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent arg0){
                if((arg0.getModifiers() & ActionEvent.ALT_MASK) > 0){
                    JOptionPane.showMessageDialog(Okno.this, "Alt był wcisniety");
                }
            }
        }; 
        button.addActionListener(event);
        pack();
    }
}