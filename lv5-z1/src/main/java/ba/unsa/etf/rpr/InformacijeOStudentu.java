package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije implements Predstavljiv{
    private String ime;
    private String prezime;
    private String godinaStudija;
    private String brojIndexa;

    public String predstavi(){
        return ime + " " + prezime + " " + godinaStudija + " " + brojIndexa;
    }
    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
}
