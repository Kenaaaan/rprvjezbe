package ba.unsa.etf.rpr;

public class InformacijeONastavniku extends LicneInformacije implements Predstavljiv{
    private String ime;
    private String prezime;
    private String titula;

    public String getIme() {
        return ime;
    }

    public String predstavi(){
        return ime + " " + prezime + " " + titula;
    }
    public String getPrezime() {
        return prezime;
    }

    public String getTitula() {
        return titula;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
}
