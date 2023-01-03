package interfejsgraficzny;

import button13.ZaleznaOdPensji;
import button2.JakSortuj;
import button2.JakSortuj1;

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
        MainFrame.dodajPanel(jPanel);


    }
}
