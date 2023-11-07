package ba.unsa.etf.rpr;

//import java.util.Objects;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{

    private Grad grad;
    private String broj;


    public FiksniBroj(Grad grad,String broj){
        if(grad==null)throw new BrojException("Uneseni pozivni broj za fiksni telefon nije OK");
        this.grad=grad;
        this.broj=broj;
    }

    @Override
    public String ispisi(){
        if(this.grad!=null && this.broj!=null){
            return grad.getPozivniBroj()+"/"+broj;
        }
        else{
            return null;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(grad,broj);
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }


}
