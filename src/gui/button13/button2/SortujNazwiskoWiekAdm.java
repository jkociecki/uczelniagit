package gui.button13.button2;

import gui.button13.interfejsgraficzny.MainFrame;
import uczelnia.PracownikAdministracyjny;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortujNazwiskoWiekAdm implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Nadgodziny"};
        String[][] dane = PracownikAdministracyjny.getLista(1);
        JTable jTable = new JTable(dane,kolumny);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
    }


}
