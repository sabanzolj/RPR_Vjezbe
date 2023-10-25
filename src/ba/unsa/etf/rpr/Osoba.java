package ba.unsa.etf.rpr;

public class Osoba {

    private String ime,prezime;

    public String getIme(){return ime;}

    public void setIme(String ime_osobe){
        this.ime=ime_osobe;
    }

    public String getPrezime(){return prezime;}

    public void setPrezime(String prezime_osobe){
        this.prezime=prezime_osobe;
    }

    public Osoba(String ime_osobe,String prezime_osobe){
        setIme(ime_osobe);
        setPrezime(prezime_osobe);
    }

    @Override
    public String toString(){
        return "Osoba{"+
                "ime="+ime+'\''+
                ", prezime="+prezime+'\''+
                "}";
    }
}
