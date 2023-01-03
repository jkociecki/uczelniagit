package strategia;

import uczelnia.PracownikUczelni;

public class SposobNaPodwyzkeB implements Strategia {
    public void strategia(PracownikUczelni pracownikUczelni){
        int pensja = pracownikUczelni.getPensja();
        double premia1 = 0;
        if(pensja < 3500){
            premia1 = pensja * 0.5;
            pensja *= 1.5;
        }
        else if(pensja < 8500){
            premia1 = pensja * 0.25;
            pensja *= 1.25;
        }
        else if(pensja < 12000){
            premia1 = pensja * 0.1;
            pensja *= 1.1;
        }
        pracownikUczelni.setPensja(pensja);
        long premia = Math.round(premia1);
        System.out.println("Dla pracownika: " + pracownikUczelni.getImie() +"  "+pracownikUczelni.getNazwisko());
        System.out.println("Przydzielono premie w wysokosci: "+ premia);
    }

}
