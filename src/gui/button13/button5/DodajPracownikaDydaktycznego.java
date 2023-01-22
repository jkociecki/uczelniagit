package gui.button13.button5;

import gui.button13.interfejsgraficzny.MainFrame;
import uczelnia.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajPracownikaDydaktycznego implements ActionListener {
    static int czyBlad = 0;
    public static Integer tryParse(String text){
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            czyBlad = 1;
            return -1;
        }
    }
    public static Boolean tryParseBoolean(String text){
        if(text.equals("true") || text.equals("True") || text.equals("t")){
            return true;
        }
        else if(text.equals("false") || text.equals("False") || text.equals("n")){
            return false;
        }else{
            czyBlad = 1;
            return false;
        }
    }
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        JButton jButton = new JButton("OK");
        jPanel1.add(jButton);
        JSlider jSlider = new JSlider();
        JLabel j1 = new JLabel("Imie");
        JLabel j2 = new JLabel("Nazwisko");
        JLabel j3 = new JLabel("Pesel");
        JLabel j4 = new JLabel("Wiek");
        JLabel j5 = new JLabel("Plec");
        JLabel j6 = new JLabel("Staz Pracy");
        JLabel j7 = new JLabel("Pensja");
        JLabel j8 = new JLabel("Stanowisko");
        JLabel j9 = new JLabel("Liczba Publikacji");

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
                int wiek = tryParse(t4.getText());//Integer.valueOf(t4.getText());
                String plec = t5.getText();
                int staz = tryParse(t6.getText());//Integer.valueOf(t6.getText());
                int pensja = tryParse(t7.getText());//Integer.valueOf(t7.getText());
                String stanowisko = t8.getText();
                int liczba = tryParse(t9.getText());//Integer.valueOf(t9.getText());
                if(czyBlad == 1){
                    JOptionPane.showMessageDialog(MainFrame.jFrame, "WPROWADZONE NIEPRAWIDLOWE DANE");
                }
                PracownikBadawczoDydaktyczny.dodajPracownika(new PracownikBadawczoDydaktyczny(imie,naziwsko,pesel,wiek,plec,staz,pensja,stanowisko,liczba));
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


        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Liczba Publikacji"};




    }
}
