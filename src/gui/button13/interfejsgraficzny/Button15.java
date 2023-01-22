package gui.button13.interfejsgraficzny;

import gui.button13.Button15.UsuwanieAdministracyjnych;
import gui.button13.Button15.UsuwanieDydaktycznych;
import gui.button13.button2.JakSortuj;
import gui.button13.button2.JakSortuj1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Button15 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        JButton b1 = new JButton("Usun Powtarzajacych Pracownikow Dydaktycznych");
        JButton b2 = new JButton("Usun Powtarzajacych Pracwnikow Administracyjnych");
        jPanel.add(b1);
        jPanel.add(b2);
        MainFrame.dodajPanel(jPanel);
        Color pasetl1 = new Color(248,237,227);
        Color pastel2 = new Color(223,211,195);
        b1.addActionListener(new UsuwanieDydaktycznych());
        b2.addActionListener(new UsuwanieAdministracyjnych());
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);


    }

}
