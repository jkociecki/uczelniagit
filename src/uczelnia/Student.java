package uczelnia;

import Obserwator.Subject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Student extends Osoba{
    static ArrayList<Student> wszyscyStudenci = new ArrayList<Student>();
    String indeks;
    int rok;
    ArrayList<Kursy> kursy = new ArrayList<Kursy>();
    boolean czyErasmus;
    boolean czyPierwszyStopien;
    boolean czyStacjonarne;

    public Student(String imie, String nazwisko, String pesel, int wiek, String plec, String indeks, int rok, ArrayList<Kursy> kursy, boolean czyErasmus, boolean czyPierwszyStopien, boolean czyStacjonarne){
        super(imie, nazwisko, pesel, wiek, plec);
        this.kursy = kursy;
        this.indeks = indeks;
        this.rok = rok;
        this.czyPierwszyStopien = czyPierwszyStopien;
        this.czyStacjonarne = czyStacjonarne;
    }

    public static void dodajStudenta(){
        Scanner scanner = new Scanner(System.in); int petla = 0;
        ArrayList<Kursy> pomoc = new ArrayList<>();
        System.out.println("Podaj imie"); String imie = scanner.next();
        System.out.println("Podaj nazwisko"); String nazwisko = scanner.next();
        System.out.println("Podaj pesel"); String pesel = scanner.next();
        System.out.println("Podaj wiek"); int wiek = scanner.nextInt();
        System.out.println("Podaj plec"); String plec = scanner.next();
        System.out.println("Podaj indeks"); String indeks = scanner.next();
        System.out.println("Podaj rok"); int rok = scanner.nextInt();
        System.out.println("Wybierz kursy: ");
        outerloop:
        while(petla == 0){
            for(int i =0; i < Kursy.wszystkieKursy.size();i++) {

                System.out.println(i + ". " + Kursy.wszystkieKursy.get(i).toString());
            }
            System.out.println("Wpisz 404 zeby zakonczyc dodawanie.");
            int ktorykurs = scanner.nextInt();
            if(ktorykurs == 404) break outerloop;
            pomoc.add(Kursy.wszystkieKursy.get(ktorykurs));


        }
        System.out.println("Czy erasmus"); boolean czyErasmus = scanner.nextBoolean();
        System.out.println("Czy 1 stopien"); boolean czypierwszy = scanner.nextBoolean();
        System.out.println("czy stacjonarnie"); boolean czystacjonarnie = scanner.nextBoolean();

        wszyscyStudenci.add(new Student(imie,nazwisko,pesel,wiek,plec,indeks,rok,pomoc,czyErasmus,czypierwszy,czystacjonarnie));
    }
    public static void dodajStudenta(Student student){
        wszyscyStudenci.add(student);
    }
    public static void wyswietlStudentow(){
        System.out.println("===============================================================");
        System.out.println("Wszyscy Studenci: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-20s%-30s\n","Imie: " , "Nazwisko: ", "Pesel: ", "Wiek: ", "Plec: ","Indeks: ", "Rok: ", "Czy Erasmus: ", "Czy 1 stopien: ","Czy stacjonarnie: ","Kursy: ");
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-20s%-30s\n",wszyscyStudenci.get(i).getImie(),wszyscyStudenci.get(i).getNazwisko(),wszyscyStudenci.get(i).getPesel(),wszyscyStudenci.get(i).getWiek(),wszyscyStudenci.get(i).getPlec(),wszyscyStudenci.get(i).getIndeks(),wszyscyStudenci.get(i).getRok(),wszyscyStudenci.get(i).czyErasmus, wszyscyStudenci.get(i).czyPierwszyStopien, wszyscyStudenci.get(i).czyStacjonarne, wszyscyStudenci.get(i).wyswietlKursy());
        }
        System.out.println("===============================================================");
        System.out.println();
    }
    public static String wyszukajStudenta(String dane){
        String wynik = "";
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            if(wszyscyStudenci.get(i).getImie().equals(dane)) wynik += wszyscyStudenci.get(i).toString() + "\n";
            else if(wszyscyStudenci.get(i).getNazwisko().equals(dane)) wynik += wszyscyStudenci.get(i).toString()+ "\n";
            else if(wszyscyStudenci.get(i).getIndeks().equals(dane)) wynik += wszyscyStudenci.get(i).toString()+ "\n";
        }
        return wynik;
    }

    public static void wszyscyStudenciSort(){
        wszyscyStudenci.sort(Student::osobaCompare);
    }
    public static void wszyscyStudenciImieNaziwkoSort(){
        wszyscyStudenci.sort(Osoba::osobaComapreNaziwskoImie);
    }
    public static void wszyscyStudenciNaziwskoWiekSort(){
        wszyscyStudenci.sort(Osoba::osoobaCompereNaziskoWiek);
    }

    public static void studenciDanegoKursu(String nazwaKursu){
        System.out.println("===============================================================");
        System.out.println("STUDENCI KURSU " + nazwaKursu);
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            for(int j = 0; j < wszyscyStudenci.get(i).getKursy().size(); j++){
                if(wszyscyStudenci.get(i).getKursy().get(j).getNazwaKursu().equals(nazwaKursu)){
                    System.out.println(wszyscyStudenci.get(i).imie + " "+wszyscyStudenci.get(i).getNazwisko() + " "+ nazwaKursu);

                }
            }
        }
        System.out.println("===============================================================");
    }
    public static String wyszukajStudentowDanegoRoku(int rokStudiow){
        String wynik = "";
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            if(wszyscyStudenci.get(i).getRok() == rokStudiow){
                wynik += wszyscyStudenci.get(i).toString();
            }
        }
        return wynik;
    }

    public static String[][] getStudentsList(){
        String[][] studenci = new String[wszyscyStudenci.size()][10];
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            String help = "";
                String[] kolumny = {"Imie","Nazwisko","Wiek","Kursy","Plec","Indeks","Rok","Czy Erasmus","Czy 1 Sopien","Czy Stasjonarnie","Kursy"};
                studenci[i][0] = wszyscyStudenci.get(i).getImie();
                studenci[i][1] = wszyscyStudenci.get(i).getNazwisko();
                studenci[i][2] = wszyscyStudenci.get(i).getWiekS();
                studenci[i][3] = wszyscyStudenci.get(i).getPlec();
                studenci[i][4] = wszyscyStudenci.get(i).getIndeks();
                String rok = Integer.toString(wszyscyStudenci.get(i).getRok());
                studenci[i][5] = rok;
                studenci[i][6] = siku(wszyscyStudenci.get(i).czyErasmus);
                studenci[i][7] = siku(wszyscyStudenci.get(i).czyPierwszyStopien);
                studenci[i][8] = siku(wszyscyStudenci.get(i).czyStacjonarne);
                studenci[i][9] = dajKursy(wszyscyStudenci.get(i));
        }
        return studenci;
    }

    public static void usunStudentow(ArrayList<Student> students){
        wszyscyStudenci.removeAll(students);
    }
    public static String[][] getStudentsListImieNaziwsko(int pomoc){
        if(pomoc == 1){
            wszyscyStudenciImieNaziwkoSort();
        }
        if(pomoc == 0){
            wszyscyStudenciNaziwskoWiekSort();
        }
        String[][] studenci = new String[wszyscyStudenci.size()][10];
        for(int i = 0; i < wszyscyStudenci.size(); i++){
            studenci[i][0] = wszyscyStudenci.get(i).getImie();
            studenci[i][1] = wszyscyStudenci.get(i).getNazwisko();
            studenci[i][2] = wszyscyStudenci.get(i).getWiekS();
            studenci[i][3] = wszyscyStudenci.get(i).getPlec();
            studenci[i][4] = wszyscyStudenci.get(i).getIndeks();
            String rok = Integer.toString(wszyscyStudenci.get(i).getRok());
            studenci[i][5] = rok;
            studenci[i][6] = siku(wszyscyStudenci.get(i).czyErasmus);
            studenci[i][7] = siku(wszyscyStudenci.get(i).czyPierwszyStopien);
            studenci[i][8] = siku(wszyscyStudenci.get(i).czyStacjonarne);
            studenci[i][9] = dajKursy(wszyscyStudenci.get(i));
        }
        return studenci;

    }
    public static String dajKursy(Student student){
        String pom = "";
        for (int i = 0; i < student.kursy.size();i++){
            pom += student.kursy.get(i).nazwaKursu + " ";
        }
        return pom;
    }
    public static void usunPowtorki(){
        TreeSet<Student> bezPowtorzen = new TreeSet<>(wszyscyStudenci);

    }



    public static String siku(boolean b){
        if(b == true) return "tak";
        else return "nie";
    }

    public boolean isCzyErasmus() {
        return czyErasmus;
    }

    public boolean isCzyPierwszyStopien() {
        return czyPierwszyStopien;
    }
    public boolean isCzyStacjonarne(){
        return czyStacjonarne;
    }

    public String getWiekS(){
        int wiek = super.getWiek();
        String wiek1 = Integer.toString(wiek);
        return wiek1;
    }

    @Override
    public String getImie() {
        return super.getImie();
    }

    public String getIndeks() {
        return indeks;
    }

    public int getRok() {
        return rok;
    }

    public ArrayList<Kursy> getKursy() {
        return kursy;
    }
    public String wyswietlKursy(){
        String pomoc = "";
        for(int i = 0; i < kursy.size(); i++){
            pomoc += kursy.get(i).nazwaKursu + " ";
        }
        return pomoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(indeks, student.indeks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indeks);
    }

    @Override
    public String toString() {
        return super.toString() +" "+  indeks +" "+ rok +" "+ czyErasmus +" "+ czyPierwszyStopien +" "+czyStacjonarne +" " + wyswietlKursy();
    }

    public static ArrayList<Student> getWszyscyStudenci() {
        return wszyscyStudenci;
    }

    public static void setWszyscyStudenci(ArrayList<Student> wszyscyStudenci) {
        Student.wszyscyStudenci = wszyscyStudenci;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setKursy(ArrayList<Kursy> kursy) {
        this.kursy = kursy;
    }

    public void setCzyErasmus(boolean czyErasmus) {
        this.czyErasmus = czyErasmus;
    }

    public void setCzyPierwszyStopien(boolean czyPierwszyStopien) {
        this.czyPierwszyStopien = czyPierwszyStopien;
    }

    public void setCzyStacjonarne(boolean czyStacjonarne) {
        this.czyStacjonarne = czyStacjonarne;
    }
}
