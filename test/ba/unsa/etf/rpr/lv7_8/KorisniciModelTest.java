package ba.unsa.etf.rpr.lv7_8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

    static KorisniciModel model=new KorisniciModel();
    @BeforeAll
    public static void napuni(){
        model.getKorisnici().add(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        model.getKorisnici().add(new Korisnik("Adil","Tutun","atutun1@etf.unsa.ba","atutun1","113456"));
        model.getKorisnici().add(new Korisnik("Amer","Dautovic","adautovic1@etf.unsa.ba","adautovic1","113456"));

    }

    @Test
    public void test1Ime(){
        model.setTrenutniKorisnik(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        String ime=model.getTrenutniKorisnik().getName();
        assertEquals("Saban",ime);
    }
@Test
    public void test2Prezime(){
        model.setTrenutniKorisnik(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        String prezime=model.getTrenutniKorisnik().getLastName();
        assertEquals("Zolj",prezime);
    }
@Test
    public void test3Email(){
        model.setTrenutniKorisnik(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        String email=model.getTrenutniKorisnik().getEmail();
        assertEquals("szolj1@etf.unsa.ba",email);
    }
@Test
    public void test4UserName(){
        model.setTrenutniKorisnik(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        String username=model.getTrenutniKorisnik().getUserName();
        assertEquals("szolj1",username);
    }
@Test
    public void test5Password(){
        model.setTrenutniKorisnik(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        String password=model.getTrenutniKorisnik().getPassword();
        assertEquals("113456",password);
    }




}