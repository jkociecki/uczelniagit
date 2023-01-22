package gui.button13.interfejsgraficzny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import uczelnia.Kursy;
import uczelnia.PracownikBadawczoDydaktyczny;

public class Button6 implements ActionListener {
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
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton b = new JButton("OK");
        JLabel l1 = new JLabel("Nazwa Kursu");;
        JLabel l2 = new JLabel("Punkty ECTS");
        JLabel l3 = new JLabel("Wybierz Prowadzacego Kursu");
        l3.setFont(new Font("Serif", Font.BOLD, 18));
        l3.setForeground(Color.GRAY);

        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        panel.add(l1); panel.add(t1);
        panel.add(l2); panel.add(t2);

        l1.setSize(100,30); l1.setLocation(80,0);
        t1.setSize(100,30); t1.setLocation(80,30);
        l2.setSize(100,30); l2.setLocation(80,60);
        t2.setSize(100,30); t2.setLocation(80,90);


        JPanel checkboxes = new JPanel();
        checkboxes.setLayout(new BoxLayout(checkboxes,BoxLayout.PAGE_AXIS));
        checkboxes.add(l3);
        ArrayList<PracownikBadawczoDydaktyczny> pracownicy = PracownikBadawczoDydaktyczny.zwrocPomoc();
        ArrayList<JCheckBox> czekboksy = new ArrayList<>();
        for(int i = 0; i < pracownicy.size(); i++){
            czekboksy.add(new JCheckBox(pracownicy.get(i).getNazwisko() + " "+pracownicy.get(i).getImie()));
            checkboxes.add(czekboksy.get(i));
        }

        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(panel,BorderLayout.CENTER);
        MainFrame.jFrame.add(checkboxes,BorderLayout.WEST);
        MainFrame.jFrame.add(b,BorderLayout.SOUTH);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nazwaKursu = t1.getText();
                int ects  = tryParse(t2.getText());
                if(czyBlad == 1){
                    JOptionPane.showMessageDialog(MainFrame.jFrame, "WPORWADZONE NIEPRAWIDLOWE DANE");
                }
                PracownikBadawczoDydaktyczny pracownikBadawczoDydaktyczny = null;
                for(int i = 0; i < czekboksy.size(); i++){
                    if(czekboksy.get(i).isSelected()){
                        pracownikBadawczoDydaktyczny = pracownicy.get(i);

                    }
                }
                Kursy.dodajKurs(new Kursy(nazwaKursu,pracownikBadawczoDydaktyczny,ects));
                JPanel dodanoStudenta = new JPanel();
                JLabel jTextField1 = new JLabel("DODANO KURS");
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
