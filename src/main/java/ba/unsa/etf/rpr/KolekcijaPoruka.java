package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;

    public List<String> getPoruke() {
        return poruke;
    }

    public KolekcijaPoruka(List<? extends Predstavljiva> lista){
        poruke=new ArrayList<>();
        for(Predstavljiva el:lista){
            poruke.add(el.predstavi());
        }
    }
}
