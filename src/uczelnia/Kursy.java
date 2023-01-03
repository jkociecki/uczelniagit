package uczelnia;
import java.util.ArrayList;
public class Kursy{
    static ArrayList<Kursy> wszystkieKursy = new ArrayList<Kursy>();
    String nazwaKursu;
    PracownikUczelni prowadzacy;
    int punktyECTS;
    public static void wyswietlKursy(){
        System.out.println("===============================================================");
        System.out.println("Wszystkie kursy: ");
        System.out.printf("%-25s%-25s%-25s%-15s\n","Nazwa Kursu", "Imie prowadzacego" , "Nazwisko Prowadzacego" , "Punkty ECTS");
        for(int i = 0; i < Kursy.wszystkieKursy.size(); i++){
            System.out.printf("%-25s%-25s%-25s%-15s\n",wszystkieKursy.get(i).getNazwaKursu(),wszystkieKursy.get(i).getProwadzacy().getImie(),wszystkieKursy.get(i).getProwadzacy().getNazwisko(),wszystkieKursy.get(i).getPunktyECTS());
        }
        System.out.println("===============================================================");
        System.out.println();
    }
    public static String szukajKursy(String klucz){
        String wynik = "";
        for(int i = 0; i < wszystkieKursy.size(); i++){
            if(wszystkieKursy.get(i).getNazwaKursu().equals(klucz)) wynik += wszystkieKursy.get(i).toString() + "\n";
            if(wszystkieKursy.get(i).getProwadzacy().getNazwisko().equals(klucz)) wynik += wszystkieKursy.get(i).toString() + "\n";
        }
        return wynik;
    }
    public static String szukajKursyInt(int rok){
        String wynik = "";
        for(int i = 0; i < wszystkieKursy.size(); i++){
            if(wszystkieKursy.get(i).getPunktyECTS() == rok){
                wynik += wszystkieKursy.get(i).toString() + "\n";
            }
        }
        return wynik;
    }
    public int compareECTS(Kursy kursy){
        if(kursy.getPunktyECTS() < punktyECTS) return 1;
        else if(kursy.getPunktyECTS() == punktyECTS){
            if(kursy.getProwadzacy().getNazwisko().compareTo(prowadzacy.getNazwisko()) < 0){
                return 1;
            }else return -1;
        }
        else return -1;
    }

    public static String[][] getLista(int pomoc){
        if(pomoc == 1) kursySortProwadzacy();
        if(pomoc == 0) kursySortEcts();
        String[][] kursy = new String[wszystkieKursy.size()][4];
        for (int i = 0; i < wszystkieKursy.size(); i++){
            kursy[i][0] = wszystkieKursy.get(i).getNazwaKursu();
            kursy[i][1] = wszystkieKursy.get(i).getProwadzacy().getImie();
            kursy[i][2] = wszystkieKursy.get(i).getProwadzacy().getNazwisko();
            kursy[i][3] = wszystkieKursy.get(i).getECTSS();
        }
        return kursy;
    }

    public String getECTSS(){
        int ects = getPunktyECTS();
        String ectss = Integer.toString(ects);
        return ectss;
    }

    public static ArrayList<Kursy> getWszystkieKursy() {
        return wszystkieKursy;
    }

    public static void kursySortEcts(){
        wszystkieKursy.sort(Kursy::compareECTS);
    }
    public int compareProwadzacy(Kursy kursy){
        if(kursy.getProwadzacy().getNazwisko().compareTo(prowadzacy.getNazwisko()) < 0){
            return 1;
        }
        else if(kursy.getProwadzacy().getNazwisko().compareTo(prowadzacy.getNazwisko()) == 0){
            if(kursy.getPunktyECTS() > punktyECTS){
                return -1;
            }
            else return 1;
        }

        return -1;
    }
    public static void kursySortProwadzacy(){
        wszystkieKursy.sort(Kursy::compareProwadzacy);
    }

    public static void wyswietlanieKursownikow(){
        System.out.println("===========================");
        System.out.println("Kursy: ");
        System.out.printf("%-15s%-15s%-15s","Nazwa kursu: ", "Nazwisko Prowadzacego: ", "Punkty ECTS");
        for(int i = 0; i < wszystkieKursy.size(); i++){
            System.out.printf("%-15s%-15s%-15s",wszystkieKursy.get(i).getNazwaKursu(), wszystkieKursy.get(i).getProwadzacy().getNazwisko(), wszystkieKursy.get(i).getPunktyECTS());
        }
    }

    public int getPunktyECTS() {
        return punktyECTS;
    }

    public PracownikUczelni getProwadzacy() {
        return prowadzacy;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public Kursy(String nazwaKursu, PracownikUczelni pracownik, int punktyECTS) {
        this.nazwaKursu = nazwaKursu;
        this.prowadzacy = pracownik;
        this.punktyECTS = punktyECTS;
    }
    public static void dodajKurs(Kursy kursy){
        wszystkieKursy.add(kursy);
    }
    public static void usunKursy(ArrayList<Kursy> kursies){
        wszystkieKursy.removeAll(kursies);
    }

    public String toString() {
        return nazwaKursu + " " + prowadzacy.imie + " " + prowadzacy.nazwisko + " " + prowadzacy.getPesel() + " " + punktyECTS;
    }
}
