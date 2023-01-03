package uczelnia;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ZapisOdczyt extends Main {
    private static int iteracja = 0;
    public static strategia.Strategia strategia;

    public static void dodajOsobe() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz co chcesz zrobic");
        System.out.printf("%-16s%-17s%-20s%-13s%-13s\n","Dodac:",  "1. Student  "," 2. Pracownik "," 3. Kurs  "," 4. Idz dalej");
        System.out.printf("%-16s%-17s%-20s%-15s\n","Wyswietlic: ","5. Studentow ", "6. Pracownikow ", "7. Kursy");
        System.out.printf("%-16s%-17s%-20s%-13s\n","Usunac: ", "8. Pracownika" ," 9. Kurs " ,"10. Studenta");
        System.out.printf("%-16s%-17s%-20s%-13s\n","Wyszukac:","11. Pracownika","12. Studenta", "13. Kurs");
        System.out.printf( "%-16s\n","14. Podwyzka dla pracownika");
        System.out.println();
        int ktoryObiekt = scanner.nextInt();
        if (ktoryObiekt == 2) {
            System.out.println("1. Pracownik Bad-Dyd 2.Pracownik Administracyjnny");
            int jakiPracownik = scanner.nextInt();
            if(jakiPracownik == 1){
                PracownikBadawczoDydaktyczny.dodajPracownikaBadawczoDydaktycznego();
            }
            if(jakiPracownik == 2){
                PracownikAdministracyjny.dodajPracownika();
            }
        }
        if (ktoryObiekt == 3) {
            //String nazwaKursu, PracownikBadawczoDydaktyczny pracownik, int punktyECTS
            System.out.println("Podaj nazwe kursu: ");
            String nazwaKursu = scanner.next();
            int pomoc = 0;
            System.out.println("Wybierz prowadzacego kurs: ");
            for (int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++) {
                System.out.println(i + ". " + PracownikUczelni.wszyscyPracownicy.get(i).getImie() + " " + PracownikUczelni.wszyscyPracownicy.get(i).getNazwisko());
            }
            int prowadzacy = scanner.nextInt();
            System.out.println("Podaj liczbe punktow ECTS:");
            int ects = scanner.nextInt();
            Kursy.wszystkieKursy.add(new Kursy(nazwaKursu, PracownikUczelni.wszyscyPracownicy.get(prowadzacy), ects));
        }
        if (ktoryObiekt == 1) {
            Student.dodajStudenta();
        }
        if (ktoryObiekt == 5) {
            System.out.println("Sortuj wedlug: 1. Bral 2. Naziwska i Imienia 3. Naziwska i wieku");
            int help = scanner.nextInt();
            if (help == 1) {
                Student.wyswietlStudentow();
            }
            if (help == 2) {
                Student.wszyscyStudenciImieNaziwkoSort();
                Student.wyswietlStudentow();
            }
            if (help == 3) {
                Student.wszyscyStudenciNaziwskoWiekSort();
                Student.wyswietlStudentow();
            }
        }
        if (ktoryObiekt == 6) {
            System.out.println("Wyswietlanie 1. Pracownikow Bad-Dyd 2. Pracownikow Administracyjnych");
            int ktorzy = scanner.nextInt();
            if(ktorzy == 1){
                System.out.println("Sortuj wedlug: 1. Brak 2. Naziwska i Imienia 3. Naziwska i wieku");
                int help = scanner.nextInt();
                if (help == 1) {
                    PracownikBadawczoDydaktyczny.wyswietlPracownikow();
                }
                if (help == 2) {
                    PracownikUczelni.wszyscyPracownicyImieNaziwskoSort();
                    PracownikBadawczoDydaktyczny.wyswietlPracownikow();
                }
                if (help == 3) {
                    PracownikUczelni.wszyscyPacownicyNazwiskoWiekSort();
                    PracownikBadawczoDydaktyczny.wyswietlPracownikow();
                }
            }
            if(ktorzy == 2){
                System.out.println("Sortuj wedlug: 1. Brak 2. Naziwska i Imienia 3. Naziwska i wieku");
                int help = scanner.nextInt();
                if(help == 1){
                    PracownikAdministracyjny.wyswietlPracownikowAdministracyjnych();
                }
                if(help == 2){
                    PracownikAdministracyjny.AdministracjaImieNazwiskoSort();
                    PracownikAdministracyjny.wyswietlPracownikowAdministracyjnych();
                }
                if(help == 3){
                    PracownikAdministracyjny.AdministracjaImieWiekSort();
                    PracownikAdministracyjny.wyswietlPracownikowAdministracyjnych();
                }
            }
        }
        if(ktoryObiekt == 7){
            System.out.println("Sortowanie wedlug 1. Punktow ECTS 2. Nazwiska Prowadzacego");
            int sortowanie = scanner.nextInt();
            if(sortowanie == 1){
                Kursy.kursySortEcts();
                Kursy.wyswietlKursy();
            }
            if(sortowanie == 2){
                Kursy.kursySortProwadzacy();
                Kursy.wyswietlKursy();
            }
        }
        if (ktoryObiekt == 8) {
            System.out.println("Usun: 1.Pracownika Administracyjnego 2. Pracownika Bad-Dyd");
            int ktory = scanner.nextInt();
            if(ktory ==2 ){
                System.out.println("Usuwanie na podstawie: 1.Imie 2.Naziwsko 3.Staz Pracy 4.Stanowisko");
                Scanner scanner1 = new Scanner(System.in);
                int help1 = scanner1.nextInt();
                if (help1 == 1) {
                    System.out.println("Podaj imie");
                    ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
                    Scanner scanner2 = new Scanner(System.in);
                    String name = scanner2.next();
                    for (int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++) {
                        if (PracownikUczelni.wszyscyPracownicy.get(i).getImie().equals(name)) {
                            found.add(PracownikUczelni.wszyscyPracownicy.get(i));
                        }
                    }
                    PracownikUczelni.wszyscyPracownicy.removeAll(found);
                }
                if (help1 == 2) {
                    System.out.println("Podaj nazwisko");
                    ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
                    String name = scanner.next();
                    for (int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++) {
                        if (PracownikUczelni.wszyscyPracownicy.get(i).getNazwisko().equals(name)) {
                            found.add(PracownikUczelni.wszyscyPracownicy.get(i));
                        }
                    }
                    //zapis();
                    //System.exit(1);
                    PracownikUczelni.wszyscyPracownicy.removeAll(found);
                }
                if (help1 == 3) {
                    System.out.println("Podaj staz pracy");
                    ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
                    int name = scanner.nextInt();
                    for (int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++) {
                        if (PracownikUczelni.wszyscyPracownicy.get(i).getStazPracy() == name) {
                            found.add(PracownikUczelni.wszyscyPracownicy.get(i));
                        }
                    }
                    PracownikUczelni.wszyscyPracownicy.removeAll(found);
                }
                if (help1 == 4) {
                    System.out.println("Podaj stanowisko");
                    ArrayList<PracownikUczelni> found = new ArrayList<PracownikUczelni>();
                    String name = scanner.next();
                    for (int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++) {
                        if (PracownikUczelni.wszyscyPracownicy.get(i).getStanowisko().equals(name)) {
                            found.add(PracownikUczelni.wszyscyPracownicy.get(i));
                        }
                    }
                    PracownikUczelni.wszyscyPracownicy.removeAll(found);
                }
            }
            if(ktory == 1){
                PracownikAdministracyjny.Usuwanie();
            }
        }
        if (ktoryObiekt == 10) {
            System.out.println("Usuwanie na podstawie: 1.Imie 2.Naziwsko 3.Indeksu 4.Rok Studiow");
            int help1 = scanner.nextInt();
            if (help1 == 1) {
                System.out.println("Podaj imie");
                ArrayList<Student> found = new ArrayList<Student>();
                String name = scanner.next();
                for (int i = 0; i < Student.wszyscyStudenci.size(); i++) {
                    if (Student.wszyscyStudenci.get(i).getImie().equals(name)) {
                        found.add(Student.wszyscyStudenci.get(i));
                    }
                }
                Student.wszyscyStudenci.removeAll(found);
            }
            if (help1 == 2) {
                System.out.println("Podaj nazwisko");
                ArrayList<Student> found = new ArrayList<Student>();
                String name = scanner.next();
                for (int i = 0; i < Student.wszyscyStudenci.size(); i++) {
                    if (Student.wszyscyStudenci.get(i).getNazwisko().equals(name)) {
                        found.add(Student.wszyscyStudenci.get(i));
                    }
                }
                Student.wszyscyStudenci.removeAll(found);
            }
            if (help1 == 3) {
                ArrayList<Student> found = new ArrayList<Student>();
                System.out.println("Podaj indeks");
                String name = scanner.next();
                for (int i = 0; i < Student.wszyscyStudenci.size(); i++) {
                    if (Student.wszyscyStudenci.get(i).getIndeks().equals(name)) {
                        found.add(Student.wszyscyStudenci.get(i));
                    }
                }
                Student.wszyscyStudenci.removeAll(found);
            }
            if (help1 == 4) {
                ArrayList<Student> found = new ArrayList<Student>();
                System.out.println("Podaj rok studiow");
                int name = scanner.nextInt();
                for (int i = 0; i < Student.wszyscyStudenci.size(); i++) {
                    if (Student.wszyscyStudenci.get(i).getRok() == name) {
                        found.add(Student.wszyscyStudenci.get(i));
                    }
                }
                Student.wszyscyStudenci.removeAll(found);
            }
        }
        if(ktoryObiekt == 9){
            System.out.println("Usun wedlug: 1. Nazwy kursu  2. Punktow ECTS");
            int help = scanner.nextInt();
            if(help == 1){
                System.out.println("Podaj nazwe kursu");
                String name = scanner.next();
                ArrayList<Kursy> found = new ArrayList<Kursy>();
                for(int i = 0; i < Kursy.wszystkieKursy.size(); i++){
                    if(Kursy.wszystkieKursy.get(i).getNazwaKursu().equals(name)){
                        found.add(Kursy.wszystkieKursy.get(i));
                    }
                }
                Kursy.wszystkieKursy.removeAll(found);
            }
            if(help == 2){
                System.out.println("Podaj liczbe punktow ECTS:");
                int name = scanner.nextInt();
                ArrayList<Kursy> found = new ArrayList<Kursy>();
                for(int i = 0; i < Kursy.wszystkieKursy.size(); i++){
                    if(Kursy.wszystkieKursy.get(i).getPunktyECTS() == name){
                        found.add(Kursy.wszystkieKursy.get(i));
                    }
                }
                Kursy.wszystkieKursy.removeAll(found);
            }
        }
        if(ktoryObiekt == 11){
            System.out.println("Wyszukiwanie przez");
            System.out.println("1.Imie 2.Naziwsko 3.Staz Pracy 4.Stanowisko");
            int wyszukiwanie = scanner.nextInt();
            if(wyszukiwanie == 1 || wyszukiwanie == 2 || wyszukiwanie == 4){
                System.out.println("Podaj klucz");
                String pom = scanner.next();
                System.out.println("Pracownicy Badawczo Dydaktyczni: ");
                System.out.println(PracownikBadawczoDydaktyczny.wyszukajPracownika(pom));
                System.out.println("Pracownicy Administracyjni: ");
                System.out.println(PracownikAdministracyjny.wyszukajPracownika(pom));
            }
            if(wyszukiwanie == 3){
                System.out.println("Podaj klucz"); int klucz = scanner.nextInt();
                System.out.println("Pracownicy Badawczo Dydaktyczni: ");
                System.out.println(PracownikBadawczoDydaktyczny.wyszukajPracownika(klucz));
                System.out.println("Pracownicy Administracyjni: ");
                System.out.println(PracownikAdministracyjny.szukajPoStazu(klucz));

            }
        }
        if(ktoryObiekt == 12){
            System.out.println("Wyszukiwanie przez: ");
            System.out.println("1. Imie 2. Nazwisko 3. Indeks 4. Rok studiow");
            int anie = scanner.nextInt();
            if(anie == 1 || anie == 2 || anie == 3){
                System.out.println("Podaj klucz");
                String cc = scanner.next();
                System.out.println(Student.wyszukajStudenta(cc));
            }
            if(anie == 4){
                System.out.println("Podaj klucz:");
                int roook = scanner.nextInt();
                System.out.println(Student.wyszukajStudentowDanegoRoku(roook));
            }
        }
        if(ktoryObiekt == 13){
            System.out.println("Wyszukiwanie przez:");
            System.out.println("1. Nazwe kursu 2. Nazwisko prowadzacego 3. Punkty Ects");
            int szuk = scanner.nextInt();
            if(szuk == 1 || szuk ==2 ){
                System.out.println("Podaj klucz: ");
                String kur = scanner.next();
                System.out.println(Kursy.szukajKursy(kur));
            }
            if(szuk == 3){
                System.out.println("Podaj klucz: ");
                int kur = scanner.nextInt();
                System.out.println(Kursy.szukajKursyInt(kur));
            }
        }
        if(ktoryObiekt == 14){
            System.out.println("Ktory rodzaj podwyzki:");
            System.out.println("1. Uzalezniony od pensji  2. Niezalezny od pensji");
            int rodzaj = scanner.nextInt();
            if(rodzaj == 1){
                System.out.println("Podaj pesel pracownika, ktoremy chcesz dac podwyzke");
                String pesel = scanner.next();
                PracownikUczelni pracownikUczelni = null;
                if(PracownikUczelni.strategiaSearch(pesel) == null){
                     pracownikUczelni = PracownikAdministracyjny.StrategiaSearch(pesel);
                }else{
                    pracownikUczelni = PracownikUczelni.strategiaSearch(pesel);
                }
                strategia = new strategia.SposobNaPodwyzkeA();
                strategia.strategia(pracownikUczelni);
            }
            if(rodzaj == 2){
                System.out.println("Podaj pesel pracownika, ktoremy chcesz dac podwyzke");
                String pesel = scanner.next();
                PracownikUczelni pracownikUczelni = null;
                if(PracownikUczelni.strategiaSearch(pesel) == null){
                    pracownikUczelni = PracownikAdministracyjny.StrategiaSearch(pesel);
                }else{
                    pracownikUczelni = PracownikUczelni.strategiaSearch(pesel);
                }
                strategia = new strategia.SposobNaPodwyzkeB();
                strategia.strategia(pracownikUczelni);
            }

        }

        System.out.println("czy chcesz kontynuowac?");
        System.out.println("1 -> tak");
        int koniec = scanner.nextInt();
        if(koniec == 1) dodajOsobe();

    }
    public static void odczyt() throws IOException, NumberFormatException{
        boolean czyErasmus; boolean czyPierwszyStopien; boolean czyStacjonarne;
        String imie; String nazwisko; String pesel; int wiek; String plec; int stazPracy; int pensja; String stanowiskoPracy; int liczbaPublikacji;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\pracownicy.txt");
            FileReader fileReaderKursy = new FileReader("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\kursy.txt");
            FileReader fileReaderAdm = new FileReader("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\Administracja.txt");

            FileReader fileReaderStudenci = new FileReader("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\studenciaki.txt");
            BufferedReader bufferedReaderStudenci = new BufferedReader(fileReaderStudenci);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReaderKursy = new BufferedReader(fileReaderKursy);
            BufferedReader bufferedReaderAdm = new BufferedReader(fileReaderAdm);
            String lineAmd = null;
            String line = null;
            String line1 = null;
            String line3 = null;
            while((lineAmd = bufferedReaderAdm.readLine()) != null){
                String[] s = lineAmd.split(" ");
                imie = s[0]; nazwisko = s[1]; pesel = s[2]; plec = s[4];
                wiek = Integer.valueOf(s[3]); stazPracy = Integer.valueOf(s[5]);
                pensja = Integer.valueOf(s[6]); String stanowisko = s[7];
                int nadgodziny = Integer.valueOf(s[8]);
                PracownikAdministracyjny.pracownicyAdministracyjni.add(new PracownikAdministracyjny(imie,nazwisko,pesel,wiek,plec,stazPracy,pensja,stanowisko,nadgodziny));
            }
            while ((line = bufferedReader.readLine())!= null){
                String[] s = line.split(" ");
                imie = s[0]; nazwisko = s[1]; pesel = s[2]; plec = s[4];
                wiek = Integer.valueOf(s[3]); stazPracy = Integer.valueOf(s[5]);
                pensja = Integer.valueOf(s[6]); stanowiskoPracy = s[7];
                liczbaPublikacji = Integer.valueOf(s[8]);
                PracownikUczelni.wszyscyPracownicy.add(new PracownikBadawczoDydaktyczny(imie,nazwisko,pesel,wiek,plec,stazPracy,pensja,stanowiskoPracy,liczbaPublikacji));
                PracownikBadawczoDydaktyczny.pomoc.add(new PracownikBadawczoDydaktyczny(imie,nazwisko,pesel,wiek,plec,stazPracy,pensja,stanowiskoPracy,liczbaPublikacji));
            }
            while ((line1 = bufferedReaderKursy.readLine()) != null){
                String[] c = line1.split(" ");
                for(int i = 0; i < PracownikUczelni.wszyscyPracownicy.size(); i++){
                    PracownikUczelni pracownikUczelni = null;
                    int ects = Integer.valueOf(c[4]);
                    if(PracownikUczelni.wszyscyPracownicy.get(i).getPesel().equals(c[3])){
                        pracownikUczelni = PracownikUczelni.wszyscyPracownicy.get(i);
                        Kursy.wszystkieKursy.add(new Kursy(c[0],pracownikUczelni,ects));
                    }
                }
            }
            while ((line3 = bufferedReaderStudenci.readLine()) != null){
                String[] s = line3.split(" ");
                //toString() +" "+  indeks +" "+ rok +" "+ czyErasmus +" "+ czyPierwszyStopien +" "+czyStacjonarne +" "+kursy.toString();
                String imie1 = s[0]; String nazwisko1 = s[1]; String pesel1 = s[2]; int wiek1 = Integer.valueOf(s[3]);
                int rok = Integer.valueOf(s[6]);
                String plec1 = s[4]; String indeks1 = s[5]; boolean czyErasmus1 = Boolean.parseBoolean(s[7]);
                boolean czyPierwszyStopien1 = Boolean.parseBoolean(s[8]); boolean czySacjonarnie1 = Boolean.parseBoolean(s[9]);
                ArrayList<Kursy> pom = new ArrayList<Kursy>();
                for(int i = 10; i < s.length; i++){
                    pom.add(new Kursy(s[i],null,0));
                }
                Student.wszyscyStudenci.add(new Student(imie1,nazwisko1,pesel1,wiek1,plec1,indeks1,rok,pom,czyErasmus1,czyPierwszyStopien1,czySacjonarnie1));

            }
            bufferedReaderKursy.close();
            bufferedReader.close();
            bufferedReaderStudenci.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public static void zapis(){
        try {
            FileWriter file = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\studenciaki.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for(int i = 0; i < Student.wszyscyStudenci.size(); i++){
                bufferedWriter.write(Student.wszyscyStudenci.get(i).toString() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter file2 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\Administracja.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(file2);
            for(int i = 0; i < PracownikAdministracyjny.pracownicyAdministracyjni.size(); i++){
                bufferedWriter.write(PracownikAdministracyjny.pracownicyAdministracyjni.get(i).toString()+ "\n");
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileWriter file1 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\pracownicy.txt");
            BufferedWriter bufferedWriter1 = new BufferedWriter(file1);
            for(int i = 0; i < PracownikUczelni.wszyscyPracownicy.size() ; i++){
                bufferedWriter1.write(PracownikUczelni.wszyscyPracownicy.get(i).toString() + "\n");

            }
            bufferedWriter1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter file2 = new FileWriter("C:\\Users\\Flex 5 IIL\\IdeaProjects\\Uczelnia\\src\\Uczelnia\\kursy.txt");
            BufferedWriter bufferedWriter2 = new BufferedWriter(file2);
            for(int i = 0; i < Kursy.wszystkieKursy.size(); i++){
                bufferedWriter2.write(Kursy.wszystkieKursy.get(i).toString() + "\n");
            }
            bufferedWriter2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
