package button13;

import interfejsgraficzny.MainFrame;
import uczelnia.PracownikAdministracyjny;
import uczelnia.PracownikUczelni;
import uczelnia.ZapisOdczyt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZaleznaOdPensji implements ActionListener {
    public static strategia.Strategia strategia;

    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel jLabel = new JLabel("Wpisz pesel pracownika");
        JTextField jTextField = new JTextField("");
        JButton jButton = new JButton("OK");

        jPanel.add(jLabel); jPanel.add(jTextField); jPanel.add(jButton);

        jLabel.setSize(250,100); jLabel.setLocation(315,0);
        jTextField.setSize(200,50); jTextField.setLocation(300,100);
        jButton.setSize(200,75); jButton.setLocation(300,175);

        MainFrame.dodajPanel(jPanel);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesel = jTextField.getText();
                PracownikUczelni pracownikUczelni = null;
                if(PracownikUczelni.strategiaSearch(pesel) == null){
                    pracownikUczelni = PracownikAdministracyjny.StrategiaSearch(pesel);
                }else{
                    pracownikUczelni = PracownikUczelni.strategiaSearch(pesel);
                }
                strategia = new strategia.SposobNaPodwyzkeA();
                strategia.strategia(pracownikUczelni);
            }
        });
    }
}
