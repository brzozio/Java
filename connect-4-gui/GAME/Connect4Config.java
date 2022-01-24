import javax.swing.JDialog;
import java.util.Scanner;
import javax.swing.SwingUtilities;

import javax.swing.table.TableColumn;

import javax.swing.JButton; // przyciski
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Connect4Config extends JDialog{
    //pola

    int wiersze,kolumny,iloscGraczy;

    public Connect4Config(){
        super((JDialog)null, true);
        createGUI();
    }

    public void createGUI(){
        // utworzone i ulozone komponenty
        setTitle("Rozmiar planszy");
        setSize(500,500);

       
        setLayout(new SpringLayout());
        setLocationRelativeTo(null);
        
        JLabel iloscWierszyJLabel = new JLabel("Ilosc wierszy: ");
            add(iloscWierszyJLabel);
            JComboBox<Integer> wierszeBox = new JComboBox();
                add(wierszeBox);
                wierszeBox.setSelectedItem(6);
        JLabel iloscKolumnJLabel = new JLabel("Ilosc kolumn: ");
            add(iloscKolumnJLabel);
            JComboBox<Integer> kolumnyBox = new JComboBox();
                add(kolumnyBox);
                kolumnyBox.setSelectedItem(7);
    
        // przycisk do grania z komputerem
        JCheckBox boxCheck = new JCheckBox();
            add(boxCheck);
        JLabel graKomputer = new JLabel("Graj z komputerem");
            add(graKomputer);

        // przyciski zakoncz oraz graj
        JButton buttonZakoncz = new JButton("Zakoncz");
            add(buttonZakoncz);
        JButton buttonGraj = new JButton("Graj");
            add(buttonGraj);

        ActionListener graj = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent e){
                Connect4GUI c4gui = new Connect4GUI(wiersze,kolumny,iloscGraczy);
                    c4gui.setVisible(true);
                this.setVisible(false);
                this.dispose();
            }
        }; 
        buttonGraj.addActionListener(graj);

        ActionListener zakoncz = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }; 
            buttonZakoncz.addActionListener(zakoncz);
        getRootPane().setDefaultButton(buttonZakoncz);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        //obsluga zdarzen dla okButton i cancelButton
        pack();
    }

    public int getRows(){
        rows = this.wiersze;
        return rows;
    }

    public int getCols(){
        cols = this.kolumny;
        return cols;
    }

    public int getNumberOfPlayers(){
        numberOfPlayers = this.iloscGraczy;
        return numberOfPlayers;
    }
}
