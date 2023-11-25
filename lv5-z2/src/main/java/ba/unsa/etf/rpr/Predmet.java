package ba.unsa.etf.rpr;

import java.awt.*;
import java.util.ArrayList;

public class Predmet implements Predstavljiv{
    private String naziv;
    private String opisPredmeta;
    private ArrayList<Integer> ocjene;
    public String getNaziv() {
        return naziv;
    }
    public String getOpisPredmeta() {
        return opisPredmeta;
    }

    public String predstavi(){
        return naziv + " " + opisPredmeta;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpisPredmeta(String opisPredmeta) {
        this.opisPredmeta = opisPredmeta;
    }

}
