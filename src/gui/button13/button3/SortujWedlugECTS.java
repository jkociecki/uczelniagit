package gui.button13.button3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.button13.interfejsgraficzny.MainFrame;
import uczelnia.Kursy;

import javax.swing.*;

public class SortujWedlugECTS implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumy = {"Nazwa Kursu", "Imie Prowadzacego", "Nazwisko Prowadzacego", "ECTS"};
        String[][] dane = Kursy.getLista(0);
        JTable jTable = new JTable(dane,kolumy);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
    }
}
