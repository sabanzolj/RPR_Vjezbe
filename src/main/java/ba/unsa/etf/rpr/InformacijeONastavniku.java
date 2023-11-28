package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends  LicneInformacije implements Predstavljiva,MozeOcijeniti{

    private String titula;

    private List<Ocjena> ocjene;

    public InformacijeONastavniku() {
        ocjene=new ArrayList<>();
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String predstavi(){
        return "Nastavnik: "+getTitula()+" "+getIme()+" "+getPrezime();
    }

    @Override
    public Ocjena ocijeni(int x){
        if(x<1 || x>10){
            System.out.println("Greska prilikom unosa ocjene, ocjena mora biti izmedju 1 i 10");
        }

        Ocjena novaOcjena=new Ocjena(this,x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
}
