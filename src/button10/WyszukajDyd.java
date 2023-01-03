package button10;

import interfejsgraficzny.MainFrame;
import uczelnia.PracownikBadawczoDydaktyczny;
import uczelnia.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WyszukajDyd implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String[] kolumny = {"Imie","Naziwsko","Pesel","Wiek","Plec","Staz Pracy","Pensja","Stanowisko","Liczba Publikacji"};
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        // 1.Imie 2.Naziwsko 3.Staz Pracy 4.Stanowisko
        JLabel jLabel = new JLabel("Szukaj Pracownika");
        JLabel l1 = new JLabel("Wyszukuj po Imieniu");
        JLabel l2 = new JLabel("Wyszukuj po Nazwisku");
        JLabel l3 = new JLabel("Wyszukuj po Stazu Pracy");
        JLabel l4 = new JLabel("Wyszukuj po Stanowisku");

        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        JTextField t3 = new JTextField("");
        JTextField t4 = new JTextField("");

        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("OK");
        JButton b3 = new JButton("OK");
        JButton b4 = new JButton("OK");

        jPanel.add(l1);
        jPanel.add(l2);
        jPanel.add(l3);
        jPanel.add(l4);
        jPanel.add(jLabel);
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);
        jPanel.add(t1);
        jPanel.add(t2);
        jPanel.add(t3);
        jPanel.add(t4);

        MainFrame.jFrame.setSize(500,500);

        jLabel.setForeground(Color.red);
        jLabel.setSize(150,25);jLabel.setLocation(0,0);

        l1.setSize(150,25);l1.setLocation(0,25);
        t1.setSize(200,50);t1.setLocation(0,50);
        b1.setSize(75,50); b1.setLocation(200,50);

        l2.setSize(150,25);l2.setLocation(0,100);
        t2.setSize(200,50);t2.setLocation(0,125);
        b2.setSize(75,50); b2.setLocation(200,125);

        l3.setSize(200,25); l3.setLocation(0,175);
        t3.setSize(200,50); t3.setLocation(0,200);
        b3.setSize(75,50); b3.setLocation(200,200);

        l4.setSize(200,25); l4.setLocation(0,250);
        t4.setSize(200,50); t4.setLocation(0,275);
        b4.setSize(75,50); b4.setLocation(200,275);

        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jPanel, BorderLayout.CENTER);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                int WielkoscTablicy = 0;
                ArrayList<PracownikBadawczoDydaktyczny> pracownicy = PracownikBadawczoDydaktyczny.zwrocPomoc();
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getImie().equals(imie)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] dane = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getImie().equals(imie)){
                        dane[iteracja][0] = pracownicy.get(i).getImie();
                        dane[iteracja][1] = pracownicy.get(i).getNazwisko();
                        dane[iteracja][2] = pracownicy.get(i).getPesel();
                        dane[iteracja][3] = pracownicy.get(i).getWiekS();
                        dane[iteracja][4] = pracownicy.get(i).getPlec();
                        dane[iteracja][5] = pracownicy.get(i).StazPracyS();
                        dane[iteracja][6] = pracownicy.get(i).getPensjaS();
                        dane[iteracja][7] = pracownicy.get(i).getStanowisko();
                        dane[iteracja][8] = pracownicy.get(i).getLiczbaPublikacjiS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(dane,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nazwisko = t2.getText();
                int WielkoscTablicy = 0;
                ArrayList<PracownikBadawczoDydaktyczny> pracownicy = PracownikBadawczoDydaktyczny.zwrocPomoc();
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getNazwisko().equals(nazwisko)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] dane = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getNazwisko().equals(nazwisko)){
                        dane[iteracja][0] = pracownicy.get(i).getImie();
                        dane[iteracja][1] = pracownicy.get(i).getNazwisko();
                        dane[iteracja][2] = pracownicy.get(i).getPesel();
                        dane[iteracja][3] = pracownicy.get(i).getWiekS();
                        dane[iteracja][4] = pracownicy.get(i).getPlec();
                        dane[iteracja][5] = pracownicy.get(i).StazPracyS();
                        dane[iteracja][6] = pracownicy.get(i).getPensjaS();
                        dane[iteracja][7] = pracownicy.get(i).getStanowisko();
                        dane[iteracja][8] = pracownicy.get(i).getLiczbaPublikacjiS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(dane,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String staz = t3.getText();
                int stazPracy = Integer.valueOf(staz);
                int WielkoscTablicy = 0;
                ArrayList<PracownikBadawczoDydaktyczny> pracownicy = PracownikBadawczoDydaktyczny.zwrocPomoc();
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getStazPracy() == stazPracy){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] dane = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getStazPracy() == stazPracy){
                        dane[iteracja][0] = pracownicy.get(i).getImie();
                        dane[iteracja][1] = pracownicy.get(i).getNazwisko();
                        dane[iteracja][2] = pracownicy.get(i).getPesel();
                        dane[iteracja][3] = pracownicy.get(i).getWiekS();
                        dane[iteracja][4] = pracownicy.get(i).getPlec();
                        dane[iteracja][5] = pracownicy.get(i).StazPracyS();
                        dane[iteracja][6] = pracownicy.get(i).getPensjaS();
                        dane[iteracja][7] = pracownicy.get(i).getStanowisko();
                        dane[iteracja][8] = pracownicy.get(i).getLiczbaPublikacjiS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(dane,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stanowisko = t4.getText();
                int WielkoscTablicy = 0;
                ArrayList<PracownikBadawczoDydaktyczny> pracownicy = PracownikBadawczoDydaktyczny.zwrocPomoc();
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getStanowisko().equals(stanowisko)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] dane = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < pracownicy.size(); i++){
                    if(pracownicy.get(i).getStanowisko().equals(stanowisko)){
                        dane[iteracja][0] = pracownicy.get(i).getImie();
                        dane[iteracja][1] = pracownicy.get(i).getNazwisko();
                        dane[iteracja][2] = pracownicy.get(i).getPesel();
                        dane[iteracja][3] = pracownicy.get(i).getWiekS();
                        dane[iteracja][4] = pracownicy.get(i).getPlec();
                        dane[iteracja][5] = pracownicy.get(i).StazPracyS();
                        dane[iteracja][6] = pracownicy.get(i).getPensjaS();
                        dane[iteracja][7] = pracownicy.get(i).getStanowisko();
                        dane[iteracja][8] = pracownicy.get(i).getLiczbaPublikacjiS();
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(dane,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
    }
}
