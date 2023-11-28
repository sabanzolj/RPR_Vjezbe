package ba.unsa.etf.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        this.ocjena = ocjena;
    }

    public LicneInformacije getOsoba() {
        return osoba;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        if(ocjena>0 && ocjena<=10) {
            this.ocjena = ocjena;
        }
        else{
            System.out.println("Greska prilikom unosa ocjene. Ocjena mora biti izmedju 1 i 10");

        }

    }


}
