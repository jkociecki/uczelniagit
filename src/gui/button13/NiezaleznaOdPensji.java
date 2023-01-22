package gui.button13;

import gui.button13.interfejsgraficzny.MainFrame;
import jdk.jshell.spi.SPIResolutionException;
import uczelnia.PracownikAdministracyjny;
import uczelnia.PracownikBadawczoDydaktyczny;
import uczelnia.PracownikUczelni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NiezaleznaOdPensji implements ActionListener {
    public static strategia.Strategia strategia;

    public void actionPerformed(ActionEvent e){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Color pasetl1 = new Color(222, 209, 192);
        jPanel.setBackground(pasetl1);

        JLabel jLabel = new JLabel("Wpisz pesel pracownika");
        JTextField jTextField = new JTextField("");
        JButton jButton = new JButton("OK");

        jPanel.add(jLabel); jPanel.add(jTextField); jPanel.add(jButton);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 20));


        jLabel.setSize(250,100); jLabel.setLocation(400,0);
        jTextField.setSize(200,50); jTextField.setLocation(400,100);
        jButton.setSize(200,75); jButton.setLocation(400,175);

        MainFrame.dodajPanel(jPanel);

        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pesel = jTextField.getText();
                PracownikUczelni pracownikUczelni = null;
                if(PracownikUczelni.strategiaSearch(pesel) == null){
                    pracownikUczelni = PracownikAdministracyjny.StrategiaSearch(pesel);
                }else{
                    pracownikUczelni = PracownikUczelni.strategiaSearch(pesel);
                }
                int pensja = pracownikUczelni.getPensja();
                double premia1 = 0;
                if(pensja < 3500){
                    premia1 = pensja * 0.5;
                    pensja *= 1.5;
                }
                else if(pensja < 8500){
                    premia1 = pensja * 0.25;
                    pensja *= 1.25;
                }
                else if(pensja < 12000){
                    premia1 = pensja * 0.1;
                    pensja *= 1.2;
                }
                else pensja *= 1.1;
                pracownikUczelni.setPensja(pensja);
                long premia = Math.round(premia1);


                String pesel1 = pracownikUczelni.getPesel();

                ArrayList<PracownikAdministracyjny> pracownicy = PracownikAdministracyjny.StrategiaSearchLista(pesel);
                ArrayList<PracownikBadawczoDydaktyczny> pracownicyB = PracownikBadawczoDydaktyczny.strategiaSearchLista(pesel);

                for(PracownikBadawczoDydaktyczny p : pracownicyB){
                    PracownikBadawczoDydaktyczny.dajPdwyzke(pesel1,pensja);
                }
                for(PracownikAdministracyjny p : pracownicy){
                    PracownikAdministracyjny.dajPodwyzke(pesel, pensja);
                }

                PracownikBadawczoDydaktyczny.dajPdwyzke(pesel1,pensja);
                PracownikAdministracyjny.dajPodwyzke(pesel1,pensja);

                JOptionPane.showMessageDialog(MainFrame.jFrame, "Dodano podwyzke pracownikowi: "+ pracownikUczelni.getImie() + " " + pracownikUczelni.getNazwisko() + "\n" +
                        "Wysokosc podwyzki: " + premia
                );
            }
        });

    }
}
