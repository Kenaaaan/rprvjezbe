package org.example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
public class ImenikTest {
    private static Imenik imenik = new Imenik();

    public static void setup() {
        imenik.dodaj("Eldar", new FiksniBroj(Grad.ZENICA, "225-883"));
        imenik.dodaj("Kenan", new FiksniBroj(Grad.SARAJEVO, "069-693"));
        imenik.dodaj("Harun", new MobilniBroj(61, "696-969"));
    }

    @Test
    public void testMockExternal(){
        Imenik i = Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Eldar")).thenReturn("Nema nista");

        String test = i.dajBroj("Eldar");
        assertEquals(test,"Nema nista");
    }

    @Test
    public void testMockInternal(){
        Map<String,TelefonskiBroj> mapa = Mockito.mock(Map.class);
        Mockito.when(mapa.get("Eldar")).thenReturn(new FiksniBroj(Grad.ZENICA, "225-883"));
        imenik.setBrojevi(mapa);

        String br = imenik.dajBroj("Eldar");
        assertNotEquals(br,"033/225-883");
        assertEquals(br,"036-213-434");
    }
}




