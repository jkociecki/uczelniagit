package gui.button13.interfejsgraficzny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import uczelnia.Kursy;
import uczelnia.Student;



public class Button4 implements ActionListener {

    static JLabel imie = new JLabel("Imie");
    static JLabel nazwisko = new JLabel("Nazwisko");
    static JLabel plec = new JLabel("Plec");
    static JLabel pesel = new JLabel("Pesel");
    static JLabel wiek = new JLabel("Wiek");
    static JLabel indeks = new JLabel("Indeks");
    static JLabel rok = new JLabel("Rok");
    static JLabel CzyErasmus = new JLabel("Czy Erasmus");
    static JLabel czy1st = new JLabel("Czy Pierwszy Stopien");
    static JLabel czyStacjonarnie = new JLabel("Czy Stacjonarnie");
    static int czyBlad = 1;

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
        JPanel buttonPane = new JPanel();
        JPanel fieldsPane  = new JPanel();
        JPanel jCheckBoxPanel = new JPanel();
        JPanel finall = new JPanel();
        JButton ok = new JButton("OK");

        JTextField imieField = new JTextField("");
        JTextField nazwiskoField = new JTextField("");
        JTextField wiekField = new JTextField("");
        JTextField plecField = new JTextField("");
        JTextField peselField = new JTextField("");
        JTextField indeksField = new JTextField("");
        JTextField rokField = new JTextField("");
        JTextField czyErasmusField = new JTextField("");
        JTextField czy1stField = new JTextField("");
        JTextField czyStacjonarnieField = new JTextField("");

        ArrayList<Kursy> kursy = Kursy.getWszystkieKursy();


        fieldsPane.setLayout(new BoxLayout(fieldsPane, BoxLayout.PAGE_AXIS));
        jCheckBoxPanel.setLayout(new BoxLayout(jCheckBoxPanel, BoxLayout.PAGE_AXIS));
        buttonPane.setLayout(new FlowLayout());

        fieldsPane.add(imie);
        fieldsPane.add(imieField);
        fieldsPane.add(nazwisko);
        fieldsPane.add(nazwiskoField);
        fieldsPane.add(wiek);
        fieldsPane.add(wiekField);
        fieldsPane.add(pesel);
        fieldsPane.add(peselField);
        fieldsPane.add(plec);
        fieldsPane.add(plecField);
        fieldsPane.add(indeks);
        fieldsPane.add(indeksField);
        fieldsPane.add(rok);
        fieldsPane.add(rokField);
        fieldsPane.add(CzyErasmus);
        fieldsPane.add(czyErasmusField);
        fieldsPane.add(czy1st);
        fieldsPane.add(czy1stField);
        fieldsPane.add(czyStacjonarnie);
        fieldsPane.add(czyStacjonarnieField);


        JLabel jLabel1 = new JLabel("Wybierz kursy studenta");
        jLabel1.setForeground(Color.GRAY);
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 20));

        jCheckBoxPanel.add(jLabel1);
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        for(int i = 0; i < kursy.size(); i++){
            checkBoxes.add(new JCheckBox(kursy.get(i).getNazwaKursu() +" , "+ kursy.get(i).getProwadzacy().getNazwisko()));
            jCheckBoxPanel.add(checkBoxes.get(i));
        }
        buttonPane.add(ok);
        finall.add(fieldsPane, BorderLayout.WEST);
        MainFrame.dodajJPanelWest(finall);
        MainFrame.jFrame.add(jCheckBoxPanel,BorderLayout.CENTER);
        MainFrame.jFrame.add(buttonPane, BorderLayout.PAGE_END);
        MainFrame.jFrame.revalidate();
        MainFrame.jFrame.repaint();

        ArrayList<Kursy> dodawanieKursow = new ArrayList<>();
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imieFinal = imieField.getText();
                String nazwiskoFinal = nazwiskoField.getText();
                int wiek =  tryParse(wiekField.getText()); //Integer.parseInt(wiekField.getText());
                String plec = plecField.getText();
                String pesel = peselField.getText();
                String indeks = indeksField.getText();
                int rok =  tryParse(rokField.getText()); //Integer.valueOf(rokField.getText());
                boolean czyErasmus = tryParseBoolean(czyErasmusField.getText());//Boolean.parseBoolean(czyErasmusField.getText());
                boolean czy1st = tryParseBoolean(czy1stField.getText());//Boolean.parseBoolean(czy1stField.getText());
                boolean czstacjo = tryParseBoolean(czyStacjonarnie.getText());//Boolean.parseBoolean(czyStacjonarnie.getText());
                if(czyBlad == 1){
                    JOptionPane.showMessageDialog(MainFrame.jFrame,"WPROWADZONE NIEPRAWIDLOWE DANE");
                }
                for(int i = 0; i < checkBoxes.size(); i++){
                    if(checkBoxes.get(i).isSelected()){
                        dodawanieKursow.add(kursy.get(i));
                    }
                }
                    Student.dodajStudenta(new Student(imieFinal,nazwiskoFinal,pesel, wiek,plec,indeks,rok,dodawanieKursow,czyErasmus,czy1st,czstacjo));
                    JPanel dodanoStudenta = new JPanel();
                    JLabel jTextField1 = new JLabel("DODANO STUDENTA");
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
