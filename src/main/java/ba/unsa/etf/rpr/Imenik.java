package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {

    private HashMap<String,TelefonskiBroj> brojevi=new HashMap<>();

    public Imenik() {
        HashMap<String,TelefonskiBroj> brojevi=new HashMap<String, TelefonskiBroj>();
    }

    public HashMap<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }

    public void setBrojevi(HashMap<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }

    public void dodaj(String ime_osobe, TelefonskiBroj broj){
        this.brojevi.put(ime_osobe,broj);
    }

    public String dajBroj(String ime){
        TelefonskiBroj broj=brojevi.get(ime);
        if(broj!=null){
            return broj.ispisi();
        }
        else{
            return null;
        }
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> ulaz:this.brojevi.entrySet()){
            if(ulaz.getValue().ispisi().equals(broj.ispisi())){
                return ulaz.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char c){
        StringBuilder builder=new StringBuilder();

        int brojac=1;
        for(Map.Entry<String,TelefonskiBroj> ulaz: brojevi.entrySet()){
            if(ulaz.getKey().startsWith(String.valueOf(c))){
                builder.append(brojac)
                        .append(". ")
                        .append(ulaz.getKey())
                        .append(" - ")
                        .append(ulaz.getValue().ispisi())
                        .append("\n");

            }
            brojac++;
        }

        return builder.toString();
    }

    private boolean TestGrada(TelefonskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj){
            return g.equals(((FiksniBroj)broj).getGrad());

        }
        else{
            return false;
        }
    }

    public Set<String> izGrada(Grad g){
        Set<String> rezultat=new TreeSet<String>();
        for(Map.Entry<String,TelefonskiBroj> ulaz: brojevi.entrySet()){
            if(TestGrada(ulaz.getValue(),g)){
                rezultat.add(ulaz.getKey());
            }

        }
        return rezultat;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){

        Set<TelefonskiBroj> rezultat=new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });

        for(Map.Entry<String,TelefonskiBroj> ulaz:brojevi.entrySet()){
            if(TestGrada(ulaz.getValue(),g)){
                rezultat.add(ulaz.getValue());
            }
        }
        return rezultat;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();

        int brojac=1;
        for(Map.Entry<String,TelefonskiBroj> ulaz: brojevi.entrySet()){
                builder.append(brojac)
                        .append(". ")
                        .append(ulaz.getKey())
                        .append(" - ")
                        .append(ulaz.getValue().ispisi())
                        .append("\n");


            brojac++;
        }

        return builder.toString();
    }
}
