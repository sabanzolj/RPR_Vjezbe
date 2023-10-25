package ba.unsa.etf.rpr;

public class Racun {
    private long brojRacuna;
    private Osoba korisnikRacuna;
    private double stanjeRacuna;
    private boolean prekoracenjeRacuna;
    private double prekoracenje;

    public Racun(Osoba korisnik,long br_racuna){
        this.korisnikRacuna=korisnik;
        this.brojRacuna=br_racuna;
        this.stanjeRacuna=0;
    }

    public boolean izvrsiUplatu(double iznos){
        this.stanjeRacuna=this.stanjeRacuna+iznos;
        return true;
    }

    public boolean izvrsiIsplatu(double iznos){
        if(iznos<=this.stanjeRacuna+this.prekoracenje){
            this.stanjeRacuna=this.stanjeRacuna-iznos;
            return true;
        }
        return false;
    }

    public void odobriPrekoracenje(double iznos){
        this.prekoracenjeRacuna=true;
        this.prekoracenje=iznos;
    }

    public boolean provjeriOdobrenjePrekoracenja(double iznos){
        if(this.prekoracenjeRacuna) {
            return this.prekoracenje >= iznos;
        }
        else return false;
    }

    public long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Osoba getKorisnikRacuna() {
        return korisnikRacuna;
    }

    public void setKorisnikRacuna(Osoba korisnikRacuna) {
        this.korisnikRacuna = korisnikRacuna;
    }

    public double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanjeRacuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    public boolean isPrekoracenjeRacuna() {
        return prekoracenjeRacuna;
    }

    public void setPrekoracenjeRacuna(boolean prekoracenjeRacuna) {
        this.prekoracenjeRacuna = prekoracenjeRacuna;
    }

    public double getPrekoracenje() {
        return prekoracenje;
    }

    public void setPrekoracenje(double prekoracenje) {
        this.prekoracenje = prekoracenje;
    }
}
