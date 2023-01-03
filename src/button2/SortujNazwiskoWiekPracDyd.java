package button2;

import interfejsgraficzny.MainFrame;
import uczelnia.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortujNazwiskoWiekPracDyd implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Liczba Publikacji"};
        String dane[][] = PracownikBadawczoDydaktyczny.getListPrac(0);
        JTable jTable = new JTable(dane,kolumny);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setBackground(Color.GRAY);
        ((DefaultTableCellRenderer)jTableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
    }

}
