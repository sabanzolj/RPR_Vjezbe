package ba.unsa.etf.rpr;

//import java.util.Objects;

import java.util.Objects;

public class MedunarodniBroj extends  TelefonskiBroj{

    private String drzava;
    private String broj;

    public MedunarodniBroj(String drzava,String broj){
        this.drzava=drzava;
        this.broj=broj;

    }

    @Override
    public String ispisi(){
        if(this.drzava!=null && this.broj!=null){
            return drzava+broj;
        }
        else{
            return null;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(drzava,broj);
    }

    public String getDrzava() {
        return drzava;
    }

    public String getBroj() {
        return broj;
    }
}
