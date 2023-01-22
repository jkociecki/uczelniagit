package gui.button13.interfejsgraficzny;

import uczelnia.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import uczelnia.Student;
import uczelnia.PracownikAdministracyjny;

public class Zapis implements ActionListener {
    public void actionPerformed(ActionEvent e){
        try {
            FileWriter file = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\studenciaki.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for(int i = 0; i < Student.getWszyscyStudenci().size(); i++){
                bufferedWriter.write(Student.getWszyscyStudenci().get(i).toString() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter file2 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\Administracja.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(file2);
            for(int i = 0; i < PracownikAdministracyjny.getPracownicyAdministracyjni().size(); i++){
                bufferedWriter.write(PracownikAdministracyjny.getPracownicyAdministracyjni().get(i).toString()+ "\n");
            }
            bufferedWriter.close();
        }catch (IOException exception){
            exception.printStackTrace();
        }

        try {
            FileWriter file1 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\pracownicy.txt");
            BufferedWriter bufferedWriter1 = new BufferedWriter(file1);
            for(int i = 0; i < PracownikUczelni.getWszyscyPracownicy().size() ; i++){
                bufferedWriter1.write(PracownikUczelni.getWszyscyPracownicy().get(i).toString() + "\n");

            }
            bufferedWriter1.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        try {
            FileWriter file2 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\uczelnia\\kursyPom");
            BufferedWriter bufferedWriter2 = new BufferedWriter(file2);
            for(int i = 0; i < Kursy.getWszystkieKursy().size(); i++){
                bufferedWriter2.write(Kursy.getWszystkieKursy().get(i).toString() + "\n");
            }
            bufferedWriter2.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
