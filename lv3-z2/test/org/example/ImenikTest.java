package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {
    private static Imenik imenik = new Imenik();

    public static void setup(){
        imenik.dodaj("Kenan", new MobilniBroj(61,"123-456"));
        imenik.dodaj("Ajla", new FiksniBroj(Grad.ZENICA, "425-296"));
        imenik.dodaj("Ensar", new MedunarodniBroj("+387","61919809"));
    }

    @Test
    public void dajBrojFound(){
        String broj=imenik.dajBroj("Kenan");
        assertEquals(broj,"123-456");
    }

    @Test
    public void dajBroj() {
        String broj = imenik.dajBroj("Ajla");
        assertEquals(broj,"032/425-296");
    }

    @Test
    public void dodajTestPositive(){
        TelefonskiBroj br= new MobilniBroj(61,"507-855");
        imenik.dodaj("Hamo",br);
        String brojStr = imenik.dajBroj("Hamo");
        assertEquals(brojStr, "061/507-855");
    }



            @Test
    public void dodajFIksniException(){
        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null,"123-123");
            }
        });
    }
    
}