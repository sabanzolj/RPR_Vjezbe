package ba.unsa.etf.rpr.test.ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class ImenikTest {

    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Saban Zolj",new MobilniBroj(62,"577890"));
        imenik.dodaj("Berina",new FiksniBroj(Grad.SARAJEVO,"457-402"));
        imenik.dodaj("Benjo",new MedunarodniBroj("+387","62223435"));
        imenik.dodaj("Mahir",new FiksniBroj(Grad.TRAVNIK,"123456"));
    }

    @Test
    public void dajBrojNotFound(){
        String broj=imenik.dajBroj("Berinsaca");
        assertNull(broj);
    }

    @Test
    public void dodajTestUspjesni(){
        TelefonskiBroj br=new MobilniBroj(62,"123-456");
        imenik.dodaj("TestOsoba",br);

        String tempBroj=imenik.dajBroj("TestOsoba");
        assertEquals(tempBroj,"062/123-456");
    }

    @Test
    public void dodajFiksniException(){

        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null,"123-456");
            }
        });
    }



}