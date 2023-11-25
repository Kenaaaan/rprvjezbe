package ba.unsa.etf.rpr;

public class Predmet implements Predstavljiv{
    private String naziv;
    private String opisPredmeta;
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
