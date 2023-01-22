package gui.button13.button2;

import gui.button13.interfejsgraficzny.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JakSortuj1 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Sortuj Wedlug Imienia i Nazwiska");
        JButton b2 = new JButton("Sortuje Wedlug Wieku i Nazwiska");
        jPanel.add(b1);
        jPanel.add(b2);
        Color pasetl1 = new Color(248,237,227);
        Color pastel2 = new Color(223,211,195);
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);
        b2.addActionListener(new SortujNazwiskoWiekAdm());
        b1.addActionListener(new SortujImieNazwiskoPracAdm());
        MainFrame.dodajPanel(jPanel);

    }
}
