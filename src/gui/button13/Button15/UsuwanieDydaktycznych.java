package gui.button13.Button15;

import gui.button13.interfejsgraficzny.MainFrame;
import uczelnia.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class UsuwanieDydaktycznych implements ActionListener{
    public void actionPerformed(ActionEvent e){
        ArrayList<PracownikBadawczoDydaktyczny> pomoc = PracownikBadawczoDydaktyczny.zwrocPomoc();
        int poczatek = pomoc.size();
        HashSet<PracownikBadawczoDydaktyczny> bezPowtorek = new HashSet<>(pomoc);
        pomoc.removeAll(pomoc);
        for(PracownikBadawczoDydaktyczny p : bezPowtorek){
            pomoc.add(p);
            System.out.println(p.toString());
        }
        int ileUsunieto = poczatek - pomoc.size();
        PracownikBadawczoDydaktyczny.setPomoc(pomoc);
        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Liczba Publikacji"};
        String dane[][] = PracownikBadawczoDydaktyczny.getListPrac(1);
        JTable jTable = new JTable(dane,kolumny);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.dodajTabele(jScrollPane);
        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setBackground(Color.GRAY);
        ((DefaultTableCellRenderer)jTableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        JOptionPane.showMessageDialog(MainFrame.jFrame, "Usunieto " + ileUsunieto + " zduplikwoanych pracownikow");


    }
}
