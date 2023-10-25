package ba.unsa.etf.rpr;

public class Korisnik extends Osoba{

    private Racun racun;
    public Korisnik(String ime_osobe, String prezime_osobe) {
        super(ime_osobe, prezime_osobe);
    }

    public void dodajRacun(Racun neki_racun){
        this.racun=neki_racun;
    }
}
