package interfejsgraficzny;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import button1.Cofnij;
import button1.SortujImieNazwisko;
import button1.SortujNazwiskoWiek;

public class Button1 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel(new GridLayout(2,1));
        jPanel.setBounds(0,0,100,100);
        JButton b1 = new JButton("Sortuj Wedlug Imienia i Nazwiska");
        JButton b2 = new JButton("Sortuje Wedlug Wieku i Nazwiska");
        jPanel.add(b1);
        jPanel.add(b2);
        MainFrame.dodajPanel(jPanel);
        b1.addActionListener(new SortujImieNazwisko());
        b2.addActionListener(new SortujNazwiskoWiek());
    }
}