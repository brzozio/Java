import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

public class Macierz extends JFrame {
    Macierz(){
        setTitle("Pierwsze okno");
        setSize(600,600);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        

        // KONTERNER GLOWNY
        Container mainContainer = new Container();
            add(mainContainer);
            mainContainer.setLayout(new BorderLayout());

        JPanel panelMacierz = new JPanel();
            mainContainer.add(panelMacierz, BorderLayout.CENTER); // dodawanie do srodka
            panelMacierz.setLayout(new GridLayout(2,2));
       
        JTextField macierz11 = new JTextField(5);
            panelMacierz.add(macierz11);
        JTextField macierz12 = new JTextField(5);
            panelMacierz.add(macierz12);
        JTextField macierz21 = new JTextField(5);
            panelMacierz.add(macierz21);
        JTextField macierz22 = new JTextField(5);
            panelMacierz.add(macierz22);
            

        JPanel southTextPanel = new JPanel();
            mainContainer.add(southTextPanel, BorderLayout.SOUTH);
            southTextPanel.setLayout(new FlowLayout());
            JButton przyciskSouthPanel = new JButton();
                southTextPanel.add(przyciskSouthPanel);

                double[][] tabela = new double[2][2];
                ActionListener event = new ActionListener(){ // towrzenie ActionListenera - odbiornika
                    public void actionPerformed(ActionEvent arg0){
                        
                        tabela[0][0] = Double.parseDouble(macierz11.getText());
                        tabela[1][0] = Double.parseDouble(macierz21.getText());
                        tabela[0][1] = Double.parseDouble(macierz12.getText());
                        tabela[1][1] = Double.parseDouble(macierz22.getText());
                      

                        double wynik = tabela[0][0]*tabela[1][1] - tabela[0][1]*tabela[1][0];
                        JOptionPane.showMessageDialog(Macierz.this, "Wynik to: " + wynik);
                     }
                 }; 
                    przyciskSouthPanel.addActionListener(event);

        pack();
    }
}