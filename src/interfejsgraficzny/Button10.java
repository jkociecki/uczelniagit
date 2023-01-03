package interfejsgraficzny;

import button3.SortujWedlugECTS;
import button3.SortujWedlugNazwiska;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import button10.WyszukajDyd;
import button10.WyszukajAdm;

public class Button10 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Wyszukaj Pracownika Badawczo Dydaktycznego");
        JButton b2 = new JButton("Wyszukaj Pracownika Administracyjnego");
        jPanel.add(b1);
        jPanel.add(b2);
        MainFrame.dodajPanel(jPanel);
        b1.addActionListener(new WyszukajDyd());
        b2.addActionListener(new WyszukajAdm());
    }
}
