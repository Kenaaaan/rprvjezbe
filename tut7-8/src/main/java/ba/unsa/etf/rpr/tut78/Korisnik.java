package ba.unsa.etf.rpr.tut78;

import javafx.beans.property.SimpleStringProperty;
import java.util.Objects;
public class Korisnik{
    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty email;
    private SimpleStringProperty korisnickoIme;
    private SimpleStringProperty lozinka;

    public Korisnik(String ime,String prezime,String email, String korisnickoIme, String password) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.lozinka = new SimpleStringProperty(password);
    }

    public Korisnik() {
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.korisnickoIme = new SimpleStringProperty();
        this.lozinka = new SimpleStringProperty();
    }
    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setKorisniskoIme(String korisniskoIme) {
        this.korisnickoIme.set(korisniskoIme);
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(ime, korisnik.ime) && Objects.equals(prezime, korisnik.prezime) && Objects.equals(email, korisnik.email)
        && Objects.equals(korisnickoIme, korisnik.korisnickoIme) && Objects.equals(lozinka, korisnik.lozinka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, email, korisnickoIme, lozinka);
    }


    @Override
    public String toString() {
        return ime.get() + " " + prezime.get();
    }


}
