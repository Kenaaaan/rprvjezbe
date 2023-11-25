package ba.unsa.etf.rpr;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;
    //private kolekcijaImena;


    public Pobjednik(KolekcijaImena k) {
        String najduzi=k.getNajduziIme();
        int razmak=najduzi.indexOf(' ');
        this.ime=najduzi.substring(0,razmak);
        this.prezime = najduzi.substring(razmak);
        this.brojZnakova = this.ime.length();
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }
}
