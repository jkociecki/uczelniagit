package gui.button13.interfejsgraficzny;

import uczelnia.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class Button14 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        ArrayList<Student> pomoc = Student.getWszyscyStudenci();
        int poczatek = pomoc.size();
        HashSet<Student> bezPowtorek = new HashSet<>(pomoc);
        pomoc.removeAll(pomoc);
        for(Student s:bezPowtorek){
            pomoc.add(s);
        }
        int ileUsunieto = poczatek - pomoc.size();
        Student.setWszyscyStudenci(pomoc);
        String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
        String[][] dane = Student.getStudentsListImieNaziwsko(1);
        JTable jTable = new JTable(dane,kolumny);
        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setBackground(Color.GRAY);
        ((DefaultTableCellRenderer)jTableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jScrollPane);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();
        JOptionPane.showMessageDialog(MainFrame.jFrame, "Usunieto " + ileUsunieto + " zduplikowanych studentow");

    }
}
