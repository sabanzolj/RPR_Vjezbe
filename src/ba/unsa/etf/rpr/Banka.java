package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banka {
    private long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;

    public Banka(){
        this.korisnici=new ArrayList<Korisnik>();
        this.uposlenici=new ArrayList<Uposlenik>();
    }



    public Korisnik kreirajNovogKorisnika(String ime,String prezime){
        Korisnik k=new Korisnik(ime,prezime);
        this.korisnici.add(k);
        return k;
    }

    public Uposlenik kreirajNovogUposlenika(String ime,String prezime){
        Uposlenik u=new Uposlenik(ime,prezime);
        this.uposlenici.add(u);
        return u;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        Racun r=null;
        for (Korisnik k : this.korisnici) {
            if(k.equals(korisnik)){
                Long brojRacuna=(new Random()).nextLong();
                r=new Racun(k,brojRacuna);
            }
            break;
        }
        return r;

    }


}
