package gui.button13.interfejsgraficzny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.button13.button10.WyszukajDyd;
import gui.button13.button10.WyszukajAdm;

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
        Color pasetl1 = new Color(248,237,227);
        Color pastel2 = new Color(223,211,195);
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);
    }
}
