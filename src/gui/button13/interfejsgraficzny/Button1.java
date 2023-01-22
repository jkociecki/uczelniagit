package gui.button13.interfejsgraficzny;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.button13.button1.SortujImieNazwisko;
import gui.button13.button1.SortujNazwiskoWiek;

public class Button1 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Sortuj Wedlug Imienia i Nazwiska");
        JButton b2 = new JButton("Sortuje Wedlug Wieku i Nazwiska");
        jPanel.add(b1);
        jPanel.add(b2);
        MainFrame.dodajPanel(jPanel);
        b1.addActionListener(new SortujImieNazwisko());
        b2.addActionListener(new SortujNazwiskoWiek());
         Color pasetl1 = new Color(248,237,227);
         Color pastel2 = new Color(223,211,195);
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);
    }
}