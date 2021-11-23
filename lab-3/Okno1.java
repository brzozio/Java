import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

public class Okno1 extends JFrame {
    Okno1(){
        setTitle("Minecraft 1.17.1");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));
        JButton button = new JButton("Przycisk 1");
            add(button);
        /*
        JButton button2 = new JButton("Przycisk 2");
            add(button2);
        JButton button3 = new JButton("Przycisk 3");
            add(button3);
        */
       JTextField textField = new JTextField(15);
        ActionListener event = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent arg0){
                if((arg0.getModifiers() & ActionEvent.ALT_MASK) > 0){
                    JOptionPane.showMessageDialog(Okno1.this, "Alt był wcisniety");
                }
            }
        }; 
        button.addActionListener(event);

        MouseAdapter mouse = new MouseAdapter(){
            public void mouseEntered(MouseEvent mouse){
                System.out.println("Button 1 hovered over");
            }
        };
        button.addMouseListener(mouse);
       
        JTextArea textArea = new JTextArea();
            add(textArea);
            textArea.setText("SIEMANKO");
        JScrollPane scrollText = new JScrollPane(textArea); // pasek przewijania dla pola tekstowego
            add(scrollText);
        pack();
    }
}