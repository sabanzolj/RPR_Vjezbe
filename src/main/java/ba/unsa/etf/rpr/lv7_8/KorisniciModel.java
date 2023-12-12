package ba.unsa.etf.rpr.lv7_8;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici= FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik=new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni(){
        korisnici.add(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        korisnici.add(new Korisnik("Adil","Tutun","atutun1@etf.unsa.ba","atutun1","113456"));

    }


}


