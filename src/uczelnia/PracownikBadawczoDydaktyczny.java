package uczelnia;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PracownikBadawczoDydaktyczny extends PracownikUczelni {
    static ArrayList<PracownikBadawczoDydaktyczny> pomoc = new ArrayList<>();
    String stanowiskoPracy;
    int liczbaPublikacji;

    public PracownikBadawczoDydaktyczny(){
        super();
        stanowiskoPracy = "";
        liczbaPublikacji = 0;
    }
    public static void wyswietlPracownikow(){
        System.out.println("===============================================================");
        System.out.println("Wszyscy prowadzacy: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","Imie: ", "Naziwsko: ", "Pesel: ", "Wiek: ", "Plec: ", "Staz Pracy: ", "Pensja: ","Stanowisko:");
        for(int i = 0; i < pomoc.size(); i++){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",pomoc.get(i).getImie(),pomoc.get(i).getNazwisko(),pomoc.get(i).getPesel(),pomoc.get(i).getWiek(),pomoc.get(i).getPlec(),pomoc.get(i).getStazPracy(),pomoc.get(i).pensja,pomoc.get(i).stanowiskoPracy);
        }
        System.out.println("===============================================================");
        System.out.println();
    }
    public static String wyszukajPracownika(String ciag){
        String wynik = "";
        for(int i = 0; i < pomoc.size(); i++){
            if(pomoc.get(i).getImie().equals(ciag)){
                wynik += pomoc.get(i).toString() + "\n";
            }
            else if(pomoc.get(i).getNazwisko().equals(ciag)){
                wynik += pomoc.get(i).toString() + "\n";
            }
            else if(pomoc.get(i).stanowiskoPracy.equals(ciag)){
                wynik += pomoc.get(i).toString() + "\n";
            }
        }
        return wynik;
    }
    public PracownikBadawczoDydaktyczny(String imie, String nazwisko, String pesel, int wiek, String plec,int stazPracy, int pensja, String stanowiskoPracy, int liczbaPublikacji){
        super(imie, nazwisko, pesel, wiek, plec, stazPracy, pensja);
        this.stanowiskoPracy = stanowiskoPracy;
        this.liczbaPublikacji = liczbaPublikacji;
    }
    public static void dodajPracownikaBadawczoDydaktycznego(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Poodaj imie");
        String imie = scanner.next();
        System.out.println("Poodaj nazwisko");
        String nazwisko = scanner.next();
        System.out.println("Podaj pesel");
        String pesel = scanner.next();
        System.out.println("Podaj stanowisko pracy");
        String stanowiskoPracy = scanner.next();
        System.out.println("Podaj plec");
        String plec = scanner.next();
        System.out.println("Podaj staz pracy");
        int stazpracy = scanner.nextInt();
        System.out.println("Podaj pensje");
        int pensja = scanner.nextInt();
        System.out.println("Poodaj wiek");
        int wiek = scanner.nextInt();
        System.out.println("Poodaj liczbe publikacji");
        int liczbaPublikacji = scanner.nextInt();
        PracownikUczelni.wszyscyPracownicy.add(new PracownikBadawczoDydaktyczny(imie, nazwisko, pesel, wiek, plec, stazpracy, pensja, stanowiskoPracy, liczbaPublikacji));
    }

    public static void dodajPracownika(PracownikBadawczoDydaktyczny pracownikBadawczoDydaktyczny){
        wszyscyPracownicy.add(pracownikBadawczoDydaktyczny);
    }
    public static ArrayList<PracownikBadawczoDydaktyczny> zwrocPomoc(){
        return pomoc;
    }
    public static void usunPoPeselu(String pesel){
        ArrayList<PracownikBadawczoDydaktyczny> pomagier = new ArrayList<>();
        for(int i = 0;i < pomoc.size(); i++){
            if(pomoc.get(i).getPesel().equals(pesel)){
                pomagier.add(pomoc.get(i));
            }
        }
        pomoc.removeAll(pomagier);
    }
    public static PracownikBadawczoDydaktyczny strategiaSearch(String pesel){
        for(int i = 0 ; i < pomoc.size(); i++){
            if(pomoc.get(i).equals(pesel)){
                return pomoc.get(i);
            }else return null;
        }
        return null;
    }
    public static ArrayList<PracownikBadawczoDydaktyczny> strategiaSearchLista(String pesel){
        ArrayList<PracownikBadawczoDydaktyczny> pomoc1 = new ArrayList<>();
        for(int i = 0 ; i < pomoc.size(); i++){
            if(pomoc.get(i).equals(pesel)){
                pomoc1.add(pomoc.get(i));
            }
        }
        return pomoc1;
    }
    public static void usunListe(ArrayList<PracownikBadawczoDydaktyczny> pracownikBadawczoDydaktycznies){
        pomoc.removeAll(pracownikBadawczoDydaktycznies);
    }
    public static String[][] getListPrac(int pomoc1){
        if(pomoc1 == 1) wszyscyPracownicyImieNaziwskoSort();
        if(pomoc1 == 0) wszyscyPacownicyNazwiskoWiekSort();
        String[][] pracownicy = new String[pomoc.size()][9];
        for (int i = 0; i < pomoc.size(); i++){
            pracownicy[i][0] = pomoc.get(i).getImie();
            pracownicy[i][1] = pomoc.get(i).getNazwisko();
            pracownicy[i][2] = pomoc.get(i).getPesel();
            pracownicy[i][3] = pomoc.get(i).getWiekS();
            pracownicy[i][4] = pomoc.get(i).getPlec();
            pracownicy[i][5] = pomoc.get(i).StazPracyS();
            pracownicy[i][6] = pomoc.get(i).getPensjaS();
            pracownicy[i][7] = pomoc.get(i).stanowiskoPracy;
            pracownicy[i][8] = pomoc.get(i).getLiczbaPublikacjiS();
        }
        return pracownicy;
    }
    public String getWiekS(){
        int wiek = super.getWiek();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }
    public static void dajPdwyzke(String pesel, int pensja){
        for(int i = 0 ; i < pomoc.size(); i++){
            if(pomoc.get(i).getPesel().equals(pesel)){
                System.out.println(pomoc.get(i).getPensjaS());
                pomoc.get(i).setPensja(pensja);
                System.out.println(pomoc.get(i).getPensja());
            }
        }
        for(PracownikUczelni p : wszyscyPracownicy){
            if(p.getPesel().equals(pesel)){
                p.setPensja(pensja);
            }
        }
    }

    public String getLiczbaPublikacjiS(){
        int wiek = getLiczbaPublikacji();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }

    public int getLiczbaPublikacji() {
        return liczbaPublikacji;
    }

    public String getPensjaS(){
        int wiek = super.getPensja();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }

    @Override
    public String getStanowisko() {
        return stanowiskoPracy;
    }

    public String StazPracyS(){
        int wiek = super.getStazPracy();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }



    public String toString(){
        return super.toString() + " " + stanowiskoPracy + " " + liczbaPublikacji;
    }


    public static void setPomoc(ArrayList<PracownikBadawczoDydaktyczny> pomoc) {
        PracownikBadawczoDydaktyczny.pomoc = pomoc;
        wszyscyPracownicy.removeAll(wszyscyPracownicy);
        for(PracownikBadawczoDydaktyczny p : pomoc){
           wszyscyPracownicy.add((PracownikUczelni) p);
        }
    }

    public void setStanowiskoPracy(String stanowiskoPracy) {
        this.stanowiskoPracy = stanowiskoPracy;
    }

    public void setLiczbaPublikacji(int liczbaPublikacji) {
        this.liczbaPublikacji = liczbaPublikacji;
    }
}
