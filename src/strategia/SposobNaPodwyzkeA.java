package strategia;

import uczelnia.PracownikUczelni;

public class SposobNaPodwyzkeA implements Strategia {
    public void strategia(PracownikUczelni pracownikUczelni){
        int premia = 0;
        int pensja = pracownikUczelni.getPensja();
        if(pensja < 3000){
            pensja += 800;
            premia = 800;
        }
        else {
            pensja += 700;
            premia = 700;
        }
        pracownikUczelni.setPensja(pensja);
        System.out.println("Dla pracownika: " + pracownikUczelni.getImie() +"  "+pracownikUczelni.getNazwisko());
        System.out.println("Przydzielono premie w wysokosci: "+ premia);
    }
}
