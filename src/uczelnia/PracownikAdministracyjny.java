package uczelnia;

import java.util.ArrayList;
import java.util.Scanner;

public class PracownikAdministracyjny extends PracownikUczelni {
    String stanowiskoPracy;
    int nadgodziny;

    static ArrayList<PracownikAdministracyjny> pracownicyAdministracyjni = new ArrayList<>();


    public PracownikAdministracyjny(){
        super();
        stanowiskoPracy = "";
        nadgodziny = 0;
    }
    public static void dodajPracownika(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Poodaj imie");
        String imie = scanner.next();
        System.out.println("Poodaj nazwisko");
        String nazwisko = scanner.next();
        System.out.println("Podaj pesel");
        String pesel = scanner.next();
        System.out.println("Poodaj wiek");
        int wiek = scanner.nextInt();
        System.out.println("Podaj plec");
        String plec = scanner.next();
        System.out.println("Podaj staz pracy");
        int stazpracy = scanner.nextInt();
        System.out.println("Podaj pensje");
        int pensja = scanner.nextInt();
        System.out.println("Poodaj stanowisko pracy:");
        String stanowisko = scanner.next();
        System.out.println("Podaj nadgodziny: ");
        int nadgodziny = scanner.nextInt();
        pracownicyAdministracyjni.add(new PracownikAdministracyjny(imie,nazwisko,pesel,wiek,plec,stazpracy,pensja,stanowisko,nadgodziny));
    }

    @Override
    public String getStanowisko() {
        return stanowiskoPracy;
    }

    public static void wyswietlPracownikowAdministracyjnych(){
        System.out.println("===============================================================");
        System.out.println("Wszyscy Pracownicy Administracyjni: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","Imie: ", "Naziwsko: ", "Pesel: ", "Wiek: ", "Plec: ", "Staz Pracy: ", "Pensja: ","Stanowisko:" ,"Nadgodziny: ");
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",pracownicyAdministracyjni.get(i).getImie(),pracownicyAdministracyjni.get(i).getNazwisko(),pracownicyAdministracyjni.get(i).getPesel(),pracownicyAdministracyjni.get(i).getWiek(),pracownicyAdministracyjni.get(i).getPlec(),pracownicyAdministracyjni.get(i).getStazPracy(),pracownicyAdministracyjni.get(i).pensja,pracownicyAdministracyjni.get(i).stanowiskoPracy,pracownicyAdministracyjni.get(i).getNadgodziny());

        }
    }
    public static String wyszukajPracownika(String ciag){
        String wynik = "";
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            if(pracownicyAdministracyjni.get(i).getImie().equals(ciag)){
                wynik += pracownicyAdministracyjni.get(i).toString() + "\n";
            }
            else if(pracownicyAdministracyjni.get(i).getNazwisko().equals(ciag)){
                wynik += pracownicyAdministracyjni.get(i).toString() + "\n";
            }
            else if(pracownicyAdministracyjni.get(i).stanowiskoPracy.equals(ciag)){
                wynik += pracownicyAdministracyjni.get(i).toString() + "\n";
            }
        }
        return wynik;
    }
    public static PracownikAdministracyjny StrategiaSearch(String pesel){
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            if(pracownicyAdministracyjni.get(i).getPesel().equals(pesel)){
                return pracownicyAdministracyjni.get(i);
            }
        }
        return null;
    }    public static ArrayList<PracownikAdministracyjny> StrategiaSearchLista(String pesel){
        ArrayList<PracownikAdministracyjny> pomoc = new ArrayList<>();
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            if(pracownicyAdministracyjni.get(i).getPesel().equals(pesel)){
                pomoc.add(pracownicyAdministracyjni.get(i));
            }
        }
        return pomoc;
    }

    public static String szukajPoStazu(int staz){
        String wynik = "";
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            wynik += pracownicyAdministracyjni.get(i).toString() + "\n";
        }
        return wynik;
    }
    public static void Usuwanie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuwanie na podstawie: 1.Imie 2.Naziwsko 3.Staz Pracy 4.Stanowisko");
        Scanner scanner1 = new Scanner(System.in);
        int help1 = scanner1.nextInt();
        if (help1 == 1) {
            System.out.println("Podaj imie");
            ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
            Scanner scanner2 = new Scanner(System.in);
            String name = scanner2.next();
            for (int i = 0; i < pracownicyAdministracyjni.size(); i++) {
                if (pracownicyAdministracyjni.get(i).getImie().equals(name)) {
                    found.add(pracownicyAdministracyjni.get(i));
                }
            }
            pracownicyAdministracyjni.removeAll(found);
        }
        if (help1 == 2) {
            System.out.println("Podaj nazwisko");
            ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
            String name = scanner.next();
            for (int i = 0; i < pracownicyAdministracyjni.size(); i++) {
                if (pracownicyAdministracyjni.get(i).getNazwisko().equals(name)) {
                    found.add(pracownicyAdministracyjni.get(i));
                }
            }
            //zapis();
            //System.exit(1);
            pracownicyAdministracyjni.removeAll(found);
        }
        if (help1 == 3) {
            System.out.println("Podaj staz pracy");
            ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
            int name = scanner.nextInt();
            for(PracownikAdministracyjny pracownikAdministracyjny : pracownicyAdministracyjni) {
                if (pracownikAdministracyjny.getStazPracy() == name) {
                    found.add(pracownikAdministracyjny);
                }


            }
            pracownicyAdministracyjni.removeAll(found);
        }
        if (help1 == 1) {
            System.out.println("Podaj stanowisko");
            ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
            String name = scanner.next();
            for (PracownikAdministracyjny pracownikAdministracyjny : pracownicyAdministracyjni) {
                if (pracownikAdministracyjny.getStanowisko().equals(name)) {
                    found.add(pracownikAdministracyjny);
                }
            }
            pracownicyAdministracyjni.removeAll(found);
        }
    }
    public static void dajPodwyzke(String pesel, int pensja){
        for (PracownikUczelni pracownikUczelni : wszyscyPracownicy) {
            if (pracownikUczelni.getPesel().equals(pesel)) {
                pracownikUczelni.setPensja(pensja);
            }
        }
    }
    public PracownikAdministracyjny(String imie, String nazwisko, String pesel, int wiek, String plec,int stazPracy, int pensja,String stanowiskoPracy, int nadgodziny){
        super(imie,nazwisko,pesel,wiek,plec,stazPracy,pensja);
        this.stanowiskoPracy = stanowiskoPracy;
        this.nadgodziny = nadgodziny;
    }
    public static void dodajPracownika(PracownikAdministracyjny pracownikAdministracyjny){
        pracownicyAdministracyjni.add(pracownikAdministracyjny);
    }
    public static void usunListe(ArrayList<PracownikAdministracyjny> pracownicyAdministracyjni1){
        pracownicyAdministracyjni.removeAll(pracownicyAdministracyjni1);
    }
    public static ArrayList<PracownikAdministracyjny> getPracownicyAdministracyjni() {
        return pracownicyAdministracyjni;
    }

    public static String[][] getLista(int pomoc){
        if(pomoc == 0) AdministracjaImieNazwiskoSort();
        if(pomoc == 1) AdministracjaImieWiekSort();
        String[][] pracownicy = new String[pracownicyAdministracyjni.size()][9];
        for(int i = 0; i < pracownicyAdministracyjni.size(); i++){
            pracownicy[i][0] = pracownicyAdministracyjni.get(i).getImie();
            pracownicy[i][1] = pracownicyAdministracyjni.get(i).getNazwisko();
            pracownicy[i][2] = pracownicyAdministracyjni.get(i).getPesel();
            pracownicy[i][3] = pracownicyAdministracyjni.get(i).getWiekS();
            pracownicy[i][4] = pracownicyAdministracyjni.get(i).getPlec();
            pracownicy[i][5] = pracownicyAdministracyjni.get(i).StazPracyS();
            pracownicy[i][6] = pracownicyAdministracyjni.get(i).getPensjaS();
            pracownicy[i][7] = pracownicyAdministracyjni.get(i).stanowiskoPracy;
            pracownicy[i][8] = pracownicyAdministracyjni.get(i).getget();
        }
        return pracownicy;
    }
    public String getget(){
        int wiek = getNadgodziny();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }

    public String StazPracyS(){
        int wiek = super.getStazPracy();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }

    public String getPensjaS(){
        int wiek = super.getPensja();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }
    public String getWiekS(){
        int wiek = super.getWiek();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }
    public String toString(){
        return super.toString() +" "+stanowiskoPracy+" "+nadgodziny;
    }
    public static void AdministracjaImieNazwiskoSort(){
        pracownicyAdministracyjni.sort(Osoba::osobaComapreNaziwskoImie);
    }
    public static void AdministracjaImieWiekSort(){
        pracownicyAdministracyjni.sort(Osoba::osoobaCompereNaziskoWiek);
    }

    public void setStanowiskoPracy(String stanowiskoPracy) {
        this.stanowiskoPracy = stanowiskoPracy;
    }

    public void setNadgodziny(int nadgodziny) {
        this.nadgodziny = nadgodziny;
    }

    public static void setPracownicyAdministracyjni(ArrayList<PracownikAdministracyjny> pracownicyAdministracyjni) {
        PracownikAdministracyjny.pracownicyAdministracyjni = pracownicyAdministracyjni;
    }

    public int getNadgodziny() {
        return nadgodziny;
    }
}
