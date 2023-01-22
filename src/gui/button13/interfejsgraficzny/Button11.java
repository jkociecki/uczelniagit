package gui.button13.interfejsgraficzny;

import uczelnia.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Button11 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Color pasetl1 = new Color(248,237,227);
        jPanel.setBackground(pasetl1);


        JLabel jLabel = new JLabel("Szukaj Studenta");
        JLabel l1 = new JLabel("Wyszukuj po Imieniu");
        JLabel l2 = new JLabel("Wyszukuj po Nazwisku");
        JLabel l3 = new JLabel("Wyszukuj po Indeksie");
        JLabel l4 = new JLabel("Wyszukuj po Roku Studiow");

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

        l4.setSize(200,25); l4.setLocation(375,250);
        t4.setSize(200,50); t4.setLocation(350,275);
        b4.setSize(75,50); b4.setLocation(575,275);

        MainFrame.jFrame.getContentPane().removeAll();
        MainFrame.jFrame.add(jPanel, BorderLayout.CENTER);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
                int WielkoscTablicy = 0;
                ArrayList<Student> students = Student.getWszyscyStudenci();
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getImie().equals(imie)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] studenci = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getImie().equals(imie)){
                        studenci[iteracja][0] = students.get(i).getImie();
                        studenci[iteracja][1] = students.get(i).getNazwisko();
                        studenci[iteracja][2] = students.get(i).getWiekS();
                        studenci[iteracja][3] = students.get(i).getPlec();
                        studenci[iteracja][4] = students.get(i).getIndeks();
                        String rok = Integer.toString(students.get(i).getRok());
                        studenci[iteracja][5] = rok;
                        studenci[iteracja][6] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][7] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][8] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][9] = dajKursy(students.get(i));
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(studenci,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nazwisko = t2.getText();
                String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
                int WielkoscTablicy = 0;
                ArrayList<Student> students = Student.getWszyscyStudenci();
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getNazwisko().equals(nazwisko)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] studenci = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getNazwisko().equals(nazwisko)){
                        studenci[iteracja][0] = students.get(i).getImie();
                        studenci[iteracja][1] = students.get(i).getNazwisko();
                        studenci[iteracja][2] = students.get(i).getWiekS();
                        studenci[iteracja][3] = students.get(i).getPlec();
                        studenci[iteracja][4] = students.get(i).getIndeks();
                        String rok = Integer.toString(students.get(i).getRok());
                        studenci[iteracja][5] = rok;
                        studenci[iteracja][6] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][7] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][8] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][9] = dajKursy(students.get(i));
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(studenci,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String indeks = t3.getText();
                String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
                int WielkoscTablicy = 0;
                ArrayList<Student> students = Student.getWszyscyStudenci();
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getIndeks().equals(indeks)){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] studenci = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getIndeks().equals(indeks)){
                        studenci[iteracja][0] = students.get(i).getImie();
                        studenci[iteracja][1] = students.get(i).getNazwisko();
                        studenci[iteracja][2] = students.get(i).getWiekS();
                        studenci[iteracja][3] = students.get(i).getPlec();
                        studenci[iteracja][4] = students.get(i).getIndeks();
                        String rok = Integer.toString(students.get(i).getRok());
                        studenci[iteracja][5] = rok;
                        studenci[iteracja][6] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][7] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][8] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][9] = dajKursy(students.get(i));
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(studenci,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rokS = t4.getText();
                int rok = Integer.valueOf(rokS);
                String[] kolumny = {"Imie","Nazwisko","Wiek","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
                int WielkoscTablicy = 0;
                ArrayList<Student> students = Student.getWszyscyStudenci();
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getRok() == rok){
                        WielkoscTablicy += 1;
                        System.out.println(WielkoscTablicy);
                    }
                }
                String[][] studenci = new String[WielkoscTablicy][10];
                int iteracja = 0;
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getRok() == rok){
                        studenci[iteracja][0] = students.get(i).getImie();
                        studenci[iteracja][1] = students.get(i).getNazwisko();
                        studenci[iteracja][2] = students.get(i).getWiekS();
                        studenci[iteracja][3] = students.get(i).getPlec();
                        studenci[iteracja][4] = students.get(i).getIndeks();
                        String rok69 = Integer.toString(students.get(i).getRok());
                        studenci[iteracja][5] = rok69;
                        studenci[iteracja][6] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][7] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][8] = siku(students.get(i).isCzyErasmus());
                        studenci[iteracja][9] = dajKursy(students.get(i));
                        iteracja += 1;
                    }
                }
                JTable jTable = new JTable(studenci,kolumny);
                JScrollPane jScrollPane = new JScrollPane(jTable);
                MainFrame.dodajTabele(jScrollPane);
            }
        });




    }


    public static String siku(boolean b){
        if(b == true) return "tak";
        else return "nie";
    }
    public static String dajKursy(Student student){
        String pom = "";
        for (int i = 0; i < student.getKursy().size();i++){
            pom += student.getKursy().get(i).getNazwaKursu() + " ";
        }
        return pom;
    }
}
