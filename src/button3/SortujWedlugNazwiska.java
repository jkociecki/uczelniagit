package button3;

import interfejsgraficzny.MainFrame;
import uczelnia.Kursy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortujWedlugNazwiska implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumy = {"Nazwa Kursu", "Imie Prowadzacego", "Nazwisko Prowadzacego", "ECTS"};
        String[][] dane = Kursy.getLista(1);
        JTable jTable = new JTable(dane,kolumy);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
    }
}
