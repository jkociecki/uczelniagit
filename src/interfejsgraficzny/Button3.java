package interfejsgraficzny;

import button1.SortujImieNazwisko;
import button1.SortujNazwiskoWiek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import button3.SortujWedlugECTS;
import button3.SortujWedlugNazwiska;

public class Button3 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Sortuj Wedlug Nazwiska Prowadzacego");
        JButton b2 = new JButton("Sortuj Wedlug Punktow ECTS");
        jPanel.add(b1);
        jPanel.add(b2);
        MainFrame.dodajPanel(jPanel);
        b1.addActionListener(new SortujWedlugNazwiska());
        b2.addActionListener(new SortujWedlugECTS());
    }

}
