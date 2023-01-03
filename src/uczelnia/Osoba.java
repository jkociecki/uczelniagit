package uczelnia;

public abstract class Osoba {
    String imie;
    String nazwisko;
    String pesel;
    int wiek;
    String plec;

    public Osoba(){
        imie = "";
        nazwisko = "";
        pesel = "";
        wiek = 0;
        plec = "";
    }
    public Osoba(String imie, String nazwisko, String pesel, int wiek, String plec){
        this.imie = imie;
        this.nazwisko= nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
    }
    public String toString(){
        return imie+" "+nazwisko+" "+pesel+" "+wiek+" "+plec;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getImie() {
        return imie;
    }
    public String getPlec() {
        return plec;
    }
    public int getWiek() {
        return wiek;
    }
    public String getPesel() {
        return pesel;
    }
    public int osobaCompare(Osoba osoba){
        if(osoba.getNazwisko().compareTo(nazwisko) < 0){
            return 1;
        }
        else  return -1;
    }
    public int osobaComapreNaziwskoImie(Osoba osoba){
        if(osoba.getNazwisko().compareTo(nazwisko) < 0){
            return 1;
        }
        else if(osoba.getNazwisko().compareTo(nazwisko) == 0){
            if(osoba.getImie().compareTo(imie) < 0){
                return 1;
            }
            else return -1;
        }
        else return -1;
    }

    public int osoobaCompereNaziskoWiek(Osoba osoba){
        if(osoba.getNazwisko().compareTo(nazwisko) < 0){
            return 1;
        }
        else if(osoba.getNazwisko().compareTo(nazwisko) == 0){
            if(osoba.getWiek() < wiek){
                return 1;
            }
            else return -1;
        }
        return -1;
    }
}
