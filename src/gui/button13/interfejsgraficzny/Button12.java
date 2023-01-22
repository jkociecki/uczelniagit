package gui.button13.interfejsgraficzny;

import uczelnia.Kursy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Button12 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Color pasetl1 = new Color(248,237,227);
        jPanel.setBackground(pasetl1);
        // 1.Imie 2.Naziwsko 3.Staz Pracy 4.Stanowisko
        JLabel jLabel = new JLabel("Szukaj Kurs");
        JLabel l1 = new JLabel("Po Nazwie Kursu");
        JLabel l2 = new JLabel("Po Nazwisku Prowadzacego");
        JLabel l3 = new JLabel("Po Stazu Punktach ECTS");

        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        JTextField t3 = new JTextField("");

        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("OK");
        JButton b3 = new JButton("OK");

        jPanel.add(l1);
        jPanel.add(l2);
        jPanel.add(l3);
        jPanel.add(jLabel);
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(t1);
        jPanel.add(t2);
        jPanel.add(t3);

        jLabel.setForeground(Color.red);
        jLabel.setSize(150,25);jLabel.setLocation(390,0);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 14));


        l1.setSize(150,25);l1.setLocation(375,25);
        t1.setSize(200,50);t1.setLocation(350,50);
        b1.setSize(75,50); b1.setLocation(575,50);

        l2.setSize(150,25);l2.setLocation(375,100);
        t2.setSize(200,50);t2.setLocation(350,125);
        b2.setSize(75,50); b2.setLocation(575,125);

        l3.setSize(200,25); l3.setLocation(375,175);
        t3.setSize(200,50); t3.setLocation(350,200);
        b3.setSize(75,50); b3.setLocation(575,200);


        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jPanel, BorderLayout.CENTER);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                String[] kolumy = {"Nazwa Kursu", "Imie Prowadzacego", "Nazwisko Prowadzacego", "ECTS"};
                int WielkoscTablicy = 0;
                ArrayList<Kursy> kursies = Kursy.getWszystkieKursy();
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getNazwaKursu().equals(imie)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] kursy = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getNazwaKursu().equals(imie)){
                        kursy[iteracja][0] = kursies.get(i).getNazwaKursu();
                        kursy[iteracja][1] = kursies.get(i).getProwadzacy().getImie();
                        kursy[iteracja][2] = kursies.get(i).getProwadzacy().getNazwisko();
                        kursy[iteracja][3] = kursies.get(i).getECTSS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(kursy,kolumy);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t2.getText();
                String[] kolumy = {"Nazwa Kursu", "Imie Prowadzacego", "Nazwisko Prowadzacego", "ECTS"};
                int WielkoscTablicy = 0;
                ArrayList<Kursy> kursies = Kursy.getWszystkieKursy();
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getProwadzacy().getNazwisko().equals(imie)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] kursy = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getProwadzacy().getNazwisko().equals(imie)){
                        kursy[iteracja][0] = kursies.get(i).getNazwaKursu();
                        kursy[iteracja][1] = kursies.get(i).getProwadzacy().getImie();
                        kursy[iteracja][2] = kursies.get(i).getProwadzacy().getNazwisko();
                        kursy[iteracja][3] = kursies.get(i).getECTSS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(kursy,kolumy);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t3.getText();
                int ects = Integer.valueOf(imie);
                String[] kolumy = {"Nazwa Kursu", "Imie Prowadzacego", "Nazwisko Prowadzacego", "ECTS"};
                int WielkoscTablicy = 0;
                ArrayList<Kursy> kursies = Kursy.getWszystkieKursy();
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getPunktyECTS() == ects){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] kursy = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < kursies.size(); i++){
                    if(kursies.get(i).getPunktyECTS() == ects){
                        kursy[iteracja][0] = kursies.get(i).getNazwaKursu();
                        kursy[iteracja][1] = kursies.get(i).getProwadzacy().getImie();
                        kursy[iteracja][2] = kursies.get(i).getProwadzacy().getNazwisko();
                        kursy[iteracja][3] = kursies.get(i).getECTSS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(kursy,kolumy);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });

    }

}
