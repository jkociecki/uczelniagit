package button2;

import interfejsgraficzny.MainFrame;
import uczelnia.Main;
import uczelnia.PracownikAdministracyjny;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortujImieNazwiskoPracAdm implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Nadgodziny"};
        String[][] dane = PracownikAdministracyjny.getLista(0);
        JTable jTable = new JTable(dane,kolumny);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
    }


}

