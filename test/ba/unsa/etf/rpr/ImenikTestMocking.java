package ba.unsa.etf.rpr;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTestMocking {

    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Saban Zolj",new MobilniBroj(62,"577-890"));
        imenik.dodaj("Adnan",new FiksniBroj(Grad.MOSTAR,"457-402"));
        imenik.dodaj("Berina",new MedunarodniBroj("+387","123-456"));
        imenik.dodaj("Amer",new FiksniBroj(Grad.SARAJEVO,"456-123"));
    }

    @Test
    public void TestMockVani(){
        Imenik imenik = Mockito.mock(Imenik.class); // Use the same variable name
        Mockito.when(imenik.dajBroj("Amer")).thenReturn("Nije dostupno");

        String broj = imenik.dajBroj("Amer");
        assertEquals(broj, "Nije dostupno");
    }


}