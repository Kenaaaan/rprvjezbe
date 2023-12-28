package ba.unsa.etf.rpr.tut78;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class KorisniciModel {
    private ObservableList<Korisnik> korisnici;
    private SimpleObjectProperty<Korisnik> trenutniKorisnik;

    public KorisniciModel() {
        this.korisnici = FXCollections.observableArrayList();
        this.trenutniKorisnik = new SimpleObjectProperty<>();
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }
    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni(){
        korisnici.add(new Korisnik("Korisnik", "1", "korisnik1@live.com", "korisnik1", "1234" ));
        korisnici.add(new Korisnik("Korisnik", "2", "korisnik2@gmail.com", "korisnik2","0000"));
        korisnici.add(new Korisnik("Kenan", "Abadzic","kabadzic1@etf.unsa.ba", "ludaveveric14","lolcina"));
    }

    void dodajKorisnika(Korisnik korisnik){


    }

    int size(){
        return korisnici.size();
    }
}