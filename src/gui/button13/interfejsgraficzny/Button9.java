package gui.button13.interfejsgraficzny;

import uczelnia.Kursy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Button9 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        //1. Nazwy kursu  2. Punktow ECTS

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Color pasetl1 = new Color(248,237,227);
        jPanel.setBackground(pasetl1);


        JLabel jLabel = new JLabel("Usun Kurs wedlug:");
        jLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        JLabel l1 = new JLabel("Wedlug Nazwy");
        JLabel l2 = new JLabel("Wedlug punktow ECTS");

        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");

        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("OK");

        jPanel.add(l1);
        jPanel.add(l2);
        jPanel.add(jLabel);
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(t1);
        jPanel.add(t2);

        jLabel.setForeground(Color.red);
        jLabel.setSize(150,25);jLabel.setLocation(390,0);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 14));


        l1.setSize(150,25);l1.setLocation(375,25);
        t1.setSize(200,50);t1.setLocation(350,50);
        b1.setSize(75,50); b1.setLocation(575,50);

        l2.setSize(150,25);l2.setLocation(375,100);
        t2.setSize(200,50);t2.setLocation(350,125);
        b2.setSize(75,50); b2.setLocation(575,125);

        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jPanel, BorderLayout.CENTER);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();
        ArrayList<Kursy> studenci = Kursy.getWszystkieKursy();
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                ArrayList<Kursy> found = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getNazwaKursu().equals(imie)){
                        found.add(studenci.get(i));
                    }
                }
                Kursy.usunKursy(found);
                JLabel jLabel1 = new JLabel("Usunieto Kursy:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getNazwaKursu() + " "+found.get(i).getProwadzacy().getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    popupMenu.add(znalezieni.get(i));
                    znalezieni.get(i).setSize(300,300);
                    znalezieni.get(i).setLocation(300, pomoc);
                    pomoc += 100;
                }
                popupMenu.show(MainFrame.jFrame,300,100);
                jLabel1.setSize(150,100); jLabel1.setLocation(300,0);
                ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jLabel1.setVisible(false);
                        popupMenu.setVisible(false);
                    }
                };
                new javax.swing.Timer(1500,actionListener).start();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwisko = t2.getText();
                int ects = Integer.valueOf(nazwisko);
                ArrayList<Kursy> found = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getPunktyECTS() == ects){
                        found.add(studenci.get(i));
                    }
                }
                Kursy.usunKursy(found);
                JLabel jLabel1 = new JLabel("Usunieto Kursy:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getNazwaKursu() + " "+found.get(i).getProwadzacy().getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    popupMenu.add(znalezieni.get(i));
                    znalezieni.get(i).setSize(300,300);
                    znalezieni.get(i).setLocation(300, pomoc);
                    pomoc += 100;
                }
                popupMenu.show(MainFrame.jFrame,300,100);
                jLabel1.setSize(150,100); jLabel1.setLocation(300,0);
                ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jLabel1.setVisible(false);
                        popupMenu.setVisible(false);
                    }
                };
                new javax.swing.Timer(1500,actionListener).start();
            }
        });
    }
}
