package gui.button13.interfejsgraficzny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.button13.button2.JakSortuj;
import gui.button13.button2.JakSortuj1;

public class Button2 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        JButton b1 = new JButton("Wyswietl Pracownikow Dydaktycznych");
        JButton b2 = new JButton("Wyswietl Pracownikow Administracyjnych");
        jPanel.add(b1);
        jPanel.add(b2);
        b1.addActionListener(new JakSortuj());
        b2.addActionListener(new JakSortuj1());
        MainFrame.dodajPanel(jPanel);
        Color pasetl1 = new Color(248,237,227);
        Color pastel2 = new Color(223,211,195);
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);
    }

}
