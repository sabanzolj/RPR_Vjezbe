package ba.unsa.etf.rpr;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {

    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Saban Zolj",new MobilniBroj(62,"577-890"));
        imenik.dodaj("Adnan",new FiksniBroj(Grad.MOSTAR,"457-402"));
        imenik.dodaj("Berina",new MedunarodniBroj("+387","123-456"));
        imenik.dodaj("Amer",new FiksniBroj(Grad.SARAJEVO,"456-123"));
    }



    @Test
    public void dajBrojNeuspjesno(){
        String broj=imenik.dajBroj("Samira");
        assertNull(broj);
    }

    @Test
    public void dodajUspjesno(){
        TelefonskiBroj broj=new FiksniBroj(Grad.MOSTAR,"789-456");
        imenik.dodaj("Asmir",broj);
        String br=imenik.dajBroj("Asmir");
        assertEquals("036/789-456",br);
    }


}