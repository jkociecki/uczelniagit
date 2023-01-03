package interfejsgraficzny;

import javax.swing.*;
import java.awt.*;
import button1.Cofnij;

public class MainFrame extends JFrame {

   public static JFrame jFrame = new JFrame("Uczlenia");
   static JPanel buttonPanel = new JPanel(new GridLayout(4,3));

   static JPanel schowek;


    static JButton b1 = new JButton("Wyswietl Studentow");
    static JButton b2 = new JButton("Wyswietl Pracownikow");
    static JButton b3 = new JButton("Wyswietl Kursy");
    static JButton b4 = new JButton("Dodaj Studenta");

    static JButton b5 = new JButton("Dodaj Pracownika");
    static JButton b6 = new JButton("Dodaj Kurs");

    static JButton b7 = new JButton("Usun Studenta");
    static JButton b8 = new JButton("Usun Pracownika");
    static JButton b9 = new JButton("Usun Kurs");
    static JButton b10 = new JButton("Wyszukaj Pracownika");
    static JButton b12 = new JButton("Wyszukaj Kurs");
    static JButton b11 = new JButton("Wyszukaj Studenta");
    static JButton b13 = new JButton("Daj Podwyzke");


    public MainFrame() {
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(800,400);
        buttonPanel.setBounds(0,0,100,100);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(b10);
        buttonPanel.add(b11);
        buttonPanel.add(b12);
        b13.setSize(400,100);
        jFrame.add(b13,BorderLayout.SOUTH);
        jFrame.add(buttonPanel);
        cofka();
        b1.addActionListener(new Button1());
        b2.addActionListener(new Button2());
        b3.addActionListener(new Button3());
        b4.addActionListener(new Button4());
        b5.addActionListener(new Button5());
        b6.addActionListener(new Button6());
        b7.addActionListener(new Button7());
        b8.addActionListener(new Button8());
        b9.addActionListener(new Button9());
        b10.addActionListener(new Button10());
        b11.addActionListener(new Button11());
        b12.addActionListener(new Button12());
        b13.addActionListener(new Button13());
    }

    public static void dodajPanel(JPanel jPanel){
        jFrame.getContentPane().removeAll();
        jFrame.add(jPanel);
        cofka();
        jFrame.revalidate();
        jFrame.repaint();
    }

    public static void dodajJPanelWest(JPanel jPanel){
        jFrame.getContentPane().removeAll();
        jFrame.add(jPanel , BorderLayout.WEST);
        cofka();
        jFrame.revalidate();
        jFrame.repaint();
    }


    public static void cofnij(){
        jFrame.getContentPane().removeAll();
        buttonPanel.setBounds(0,0,100,100);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(b10);
        buttonPanel.add(b11);
        buttonPanel.add(b12);
        b13.setSize(400,100);
        jFrame.add(b13,BorderLayout.SOUTH);
        jFrame.add(buttonPanel);
        jFrame.revalidate();
        jFrame.repaint();
    }

    public static void dodajTabele(JScrollPane jScrollPane){
        jFrame.getContentPane().removeAll();
        jFrame.add(jScrollPane);
        cofka();
        jFrame.revalidate();
        jFrame.repaint();
    }

    public static void cofka(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Menu");
        JMenuItem i1 = new JMenuItem("Wroc");
        JMenuItem i2 = new JMenuItem("Zapisz");
        jMenu.add(i1);
        jMenu.add(i2);
        i1.addActionListener(new Cofnij());
        i2.addActionListener(new Zapis());

        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
    }


}