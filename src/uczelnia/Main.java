package uczelnia;
import gui.button13.interfejsgraficzny.MainFrame;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException, NumberFormatException{
            ZapisOdczyt.odczyt();
            MainFrame mojaRamka = new MainFrame();
            ZapisOdczyt.dodajOsobe();
            //ZapisOdczyt.zapis();
    }
}


