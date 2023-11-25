package ba.unsa.etf.rpr;

public class LicneInformacije {
    protected String ime;
    protected String prezime;

    public String getIme() {
        return ime;
    }

    public String predstavi(){
        return ime + " " + prezime + " ";
    }
    public String getPrezime() {
        return prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

}
