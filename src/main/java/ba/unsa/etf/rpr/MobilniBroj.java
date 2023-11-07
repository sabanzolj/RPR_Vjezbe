package ba.unsa.etf.rpr;

//import java.util.Objects;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza,String broj) {
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }

    @Override
    public String ispisi(){
        if(this.broj!=null){
            return "0"+mobilnaMreza+"/"+broj;

        }
        else{
            return null;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(mobilnaMreza,broj);
    }

    public int getMobilnaMreza() {
        return mobilnaMreza;
    }

    public String getBroj() {
        return broj;
    }
}
