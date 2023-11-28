package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Predmet implements Predstavljiva,MozeOcijeniti{
    private String NazivPredmeta;

    private String OpisPredmeta;

    private List<Ocjena> ocjene;

    public Predmet(){
        ocjene=new ArrayList<>();
    }

    public String getNazivPredmeta() {
        return NazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        NazivPredmeta = nazivPredmeta;
    }

    public String getOpisPredmeta() {
        return OpisPredmeta;
    }

    public void setOpisPredmeta(String opisPredmeta) {
        OpisPredmeta = opisPredmeta;
    }


    @Override
    public String predstavi(){
        return "Predmet: "+getNazivPredmeta()+", Opis predmeta: "+getOpisPredmeta();
    }

    @Override
    public Ocjena ocijeni(int x){

        if(x<1 || x>10){
            System.out.println("Greska prilikom unosa ocjene, ocjena mora biti izmedju 1 i 10");

        }
        Ocjena novaOcjena=new Ocjena(null,x);
        ocjene.add(novaOcjena);
        return novaOcjena;

    }
}
