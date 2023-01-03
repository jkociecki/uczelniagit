package uczelnia;

import java.util.ArrayList;

public abstract class PracownikUczelni extends Osoba {
    static ArrayList<PracownikUczelni> wszyscyPracownicy = new ArrayList<PracownikUczelni>();
    String stanowisko;
    int stazPracy;
    int pensja;

    public PracownikUczelni(){
        super();
        stazPracy = 0;
        pensja = 0;
    }

    public static ArrayList<PracownikUczelni> getWszyscyPracownicy() {
        return wszyscyPracownicy;
    }
    public static void usunPracownikow(ArrayList<PracownikUczelni> pracownikUczelnis){
        wszyscyPracownicy.removeAll(pracownikUczelnis);
    }

    public PracownikUczelni(String imie, String nazwisko, String pesel, int wiek, String plec, int stazPracy, int pensja){
        super(imie, nazwisko, pesel, wiek, plec);
        this.stazPracy = stazPracy;
        this.pensja = pensja;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public static String wyszukajPracownika(int liczba){
        String wynik = "";
        for(int i = 0; i < wszyscyPracownicy.size(); i++){
            if(wszyscyPracownicy.get(i).stazPracy == liczba){
                wynik += wszyscyPracownicy.get(i).toString() + "\n";
            }
            else if(wszyscyPracownicy.get(i).pensja == liczba){
                wynik += wszyscyPracownicy.get(i).toString() + "\n";
            }
        }
        return wynik;
    }
    public static PracownikUczelni strategiaSearch(String pesel){
        for(int i = 0; i < wszyscyPracownicy.size(); i++){
            if(wszyscyPracownicy.get(i).getPesel().equals(pesel)){
                return wszyscyPracownicy.get(i);
            }
        }
        return null;
    }

    public static int getIndeksPesel(String pesel){
        for(int i = 0; i < wszyscyPracownicy.size(); i++){
            if(wszyscyPracownicy.get(i).getPesel().equals(pesel)){
                return i;
            }
        }
        return -1;
    }




    public static void wszyscyPracownicySort(){
        wszyscyPracownicy.sort(Osoba::osobaCompare);
        PracownikBadawczoDydaktyczny.pomoc.sort(Osoba::osobaCompare);
    }
    public static void wszyscyPracownicyImieNaziwskoSort(){
        wszyscyPracownicy.sort(Osoba::osobaComapreNaziwskoImie);
        PracownikBadawczoDydaktyczny.pomoc.sort(Osoba::osobaComapreNaziwskoImie);
    }

    public static void wszyscyPacownicyNazwiskoWiekSort(){
        wszyscyPracownicy.sort(Osoba::osoobaCompereNaziskoWiek);
        PracownikBadawczoDydaktyczny.pomoc.sort(Osoba::osoobaCompereNaziskoWiek);
    }


    public int getStazPracy() {
        return stazPracy;
    }

    public String toString(){
        return super.toString() +" " + stazPracy + " "+ pensja;
    }
    public String getStanowisko() {
        return stanowisko;
    }
}
