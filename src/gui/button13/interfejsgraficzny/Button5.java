package gui.button13.interfejsgraficzny;

import gui.button13.button5.DodajPracownikaAdministracyjnego;
import gui.button13.button5.DodajPracownikaDydaktycznego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button5 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Dodaj Pracownika Administracyjengo");
        JButton b2 = new JButton("Dodaj Pracownika Badawczo Dydaktycznego");
        jPanel.add(b1);
        jPanel.add(b2);
        b2.addActionListener(new DodajPracownikaDydaktycznego());
        b1.addActionListener(new DodajPracownikaAdministracyjnego());
        MainFrame.dodajPanel(jPanel);
    }
}
