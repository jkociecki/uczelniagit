package gui.button13.button1;

import gui.button13.interfejsgraficzny.MainFrame;
import uczelnia.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortujImieNazwisko implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
        String[][] dane = Student.getStudentsListImieNaziwsko(1);
        JTable jTable = new JTable(dane,kolumny);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable.getColumnModel().getColumn(0).setWidth(25);
        jTable.getColumnModel().getColumn(1).setWidth(30);
        jTable.getColumnModel().getColumn(2).setMaxWidth(35);
        jTable.getColumnModel().getColumn(3).setMaxWidth(35);
        jTable.getColumnModel().getColumn(4).setWidth(15);
        jTable.getColumnModel().getColumn(5).setMaxWidth(35);
        jTable.getColumnModel().getColumn(6).setMinWidth(100);
        jTable.getColumnModel().getColumn(7).setMinWidth(100);
        jTable.getColumnModel().getColumn(8).setMinWidth(100);
        jTable.getColumnModel().getColumn(9).setMinWidth(2000);
        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setBackground(Color.GRAY);
        ((DefaultTableCellRenderer)jTableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jScrollPane);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();
    }
}
