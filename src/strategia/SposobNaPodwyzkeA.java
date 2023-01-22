package strategia;

import uczelnia.PracownikAdministracyjny;
import uczelnia.PracownikBadawczoDydaktyczny;
import uczelnia.PracownikUczelni;
import uczelnia.ZapisOdczyt;

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
        String pesel = pracownikUczelni.getPesel();
        PracownikBadawczoDydaktyczny.dajPdwyzke(pesel,pensja);
        PracownikAdministracyjny.dajPodwyzke(pesel,pensja);

    }
}
