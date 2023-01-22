package gui.button13.interfejsgraficzny;

import gui.button13.NiezaleznaOdPensji;
import gui.button13.ZaleznaOdPensji;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button13 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        JButton b1 = new JButton("Podwyzka Zalezna Od Pensji");
        JButton b2 = new JButton("Podwyzka Niezalezna Od Pensji");
        jPanel.add(b1);
        jPanel.add(b2);

        b1.addActionListener(new ZaleznaOdPensji());
        b2.addActionListener(new NiezaleznaOdPensji());
        MainFrame.dodajPanel(jPanel);
        Color pasetl1 = new Color(248,237,227);
        Color pastel2 = new Color(223,211,195);
        b1.setBackground(pasetl1);
        b2.setBackground(pastel2);

    }
}
