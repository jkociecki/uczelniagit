package button8;

import interfejsgraficzny.MainFrame;
import uczelnia.PracownikBadawczoDydaktyczny;
import uczelnia.PracownikUczelni;
import uczelnia.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UsunDyd implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);


        JLabel jLabel = new JLabel("Usun studenta wedlug:");
        JLabel l1 = new JLabel("Wedlug Imienia");
        JLabel l2 = new JLabel("Wedlug nazwiska");
        JLabel l3 = new JLabel("Wedlug Stazu Pracy");
        JLabel l4 = new JLabel("Wedlug Stanowiska");

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
        ArrayList<PracownikBadawczoDydaktyczny> studenci = PracownikBadawczoDydaktyczny.zwrocPomoc();
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imie = t1.getText();
                ArrayList<PracownikBadawczoDydaktyczny> found = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getImie().equals(imie)){
                        found.add(studenci.get(i));
                    }
                }
                PracownikBadawczoDydaktyczny.usunListe(found);
                JLabel jLabel1 = new JLabel("Usunieto Pracownikow:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getImie() + " "+found.get(i).getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    System.out.println(found.get(i).getImie() + " "+found.get(i).getNazwisko());
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
                ArrayList<PracownikBadawczoDydaktyczny> found = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getNazwisko().equals(nazwisko)){
                        found.add(studenci.get(i));
                    }
                }
                PracownikBadawczoDydaktyczny.usunListe(found);
                JLabel jLabel1 = new JLabel("Usunieto Pracownikow:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getImie() + " "+found.get(i).getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    System.out.println(found.get(i).getImie() + " "+found.get(i).getNazwisko());
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
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indeks = t3.getText();
                int staz = Integer.valueOf(indeks);
                ArrayList<PracownikBadawczoDydaktyczny> found = new ArrayList<>();
                ArrayList<PracownikBadawczoDydaktyczny> found1 = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getStazPracy() == staz){
                        found.add(studenci.get(i));
                    }
                }
                PracownikBadawczoDydaktyczny.usunListe(found);
                JLabel jLabel1 = new JLabel("Usunieto Pracownikow:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getImie() + " "+found.get(i).getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    System.out.println(found.get(i).getImie() + " "+found.get(i).getNazwisko());
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
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indeks = t4.getText();
                int rok = Integer.valueOf(indeks);
                ArrayList<PracownikBadawczoDydaktyczny> found = new ArrayList<>();
                for(int i = 0; i < studenci.size(); i++){
                    if(studenci.get(i).getStanowisko().equals(indeks)){
                        found.add(studenci.get(i));
                    }
                }
                PracownikBadawczoDydaktyczny.usunListe(found);
                JLabel jLabel1 = new JLabel("Usunieto Pracownikow:");
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(jLabel1);
                JPanel jPanel1 = new JPanel();
                jPanel1.setLayout(null);
                ArrayList<JLabel> znalezieni = new ArrayList<>();
                int pomoc = 0;
                for(int i = 0; i < found.size(); i++){
                    znalezieni.add(new JLabel(found.get(i).getImie() + " "+found.get(i).getNazwisko()));
                    jPanel1.add(znalezieni.get(i));
                    System.out.println(found.get(i).getImie() + " "+found.get(i).getNazwisko());
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
