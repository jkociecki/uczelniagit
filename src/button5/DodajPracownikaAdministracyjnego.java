package button5;

import interfejsgraficzny.MainFrame;
import uczelnia.PracownikAdministracyjny;
import uczelnia.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPracownikaAdministracyjnego implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        JButton jButton = new JButton("OK");
        jPanel1.add(jButton);

        JLabel j1 = new JLabel("Imie");
        JLabel j2 = new JLabel("Nazwisko");
        JLabel j3 = new JLabel("Pesel");
        JLabel j4 = new JLabel("Wiek");
        JLabel j5 = new JLabel("Plec");
        JLabel j6 = new JLabel("Staz Pracy");
        JLabel j7 = new JLabel("Pensja");
        JLabel j8 = new JLabel("Stanowisko");
        JLabel j9 = new JLabel("Liczba Nadgodzin");
        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        JTextField t3 = new JTextField("");
        JTextField t4 = new JTextField("");
        JTextField t5 = new JTextField("");
        JTextField t6 = new JTextField("");
        JTextField t7 = new JTextField("");
        JTextField t8 = new JTextField("");
        JTextField t9 = new JTextField("");

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));

        jPanel.add(j1); jPanel.add(t1);
        jPanel.add(j2); jPanel.add(t2);
        jPanel.add(j3); jPanel.add(t3);
        jPanel.add(j4); jPanel.add(t4);
        jPanel.add(j5); jPanel.add(t5);
        jPanel.add(j6); jPanel.add(t6);
        jPanel.add(j7); jPanel.add(t7);
        jPanel.add(j8); jPanel.add(t8);
        jPanel.add(j9); jPanel.add(t9);

        jPanel1.add(jButton);

        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jPanel, BorderLayout.WEST);
        MainFrame.jFrame.add(jPanel1,BorderLayout.PAGE_END);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                String naziwsko = t2.getText();
                String pesel = t3.getText();
                int wiek = Integer.valueOf(t4.getText());
                String plec = t5.getText();
                int staz = Integer.valueOf(t6.getText());
                int pensja = Integer.valueOf(t7.getText());
                String stanowisko = t8.getText();
                int liczba = Integer.valueOf(t9.getText());
                PracownikAdministracyjny.dodajPracownika(new PracownikAdministracyjny(imie,naziwsko,pesel,wiek,plec,staz,pensja,stanowisko,liczba));
                JPanel dodanoStudenta = new JPanel();
                JLabel jTextField1 = new JLabel("DODANO PRACOWNIKA");
                jTextField1.setForeground(Color.green);
                MainFrame.jFrame.add(jTextField1, BorderLayout.NORTH);
                MainFrame.jFrame.revalidate();
                MainFrame.jFrame.repaint();
                ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jTextField1.setVisible(false);
                    }
                };
                new javax.swing.Timer(1500,actionListener).start();

            }
        });


    }
}
