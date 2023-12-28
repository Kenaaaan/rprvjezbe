package ba.unsa.etf.rpr.tut78;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.beans.binding.Bindings.bindBidirectional;
import static javafx.beans.binding.Bindings.unbindBidirectional;

public class Controller {
    @FXML
    public TextField prezimePolje;
    @FXML
    public TextField imePolje;
    @FXML
    public TextField emailPolje;
    @FXML
    public TextField korisnickoPolje;
    @FXML
    public PasswordField lozinkaPolje;
    @FXML
    public ListView<Korisnik> prikaz;
    private KorisniciModel model = new KorisniciModel();

    @FXML
    public void initialize() {
        model.napuni();

        // Postavljanje bidirekcione veze za trenutnog korisnika (ako postoji)
        Korisnik trenutniKorisnik = model.getTrenutniKorisnik();
        if (trenutniKorisnik != null) {
            imePolje.textProperty().bindBidirectional(trenutniKorisnik.imeProperty());
        }

        prikaz.setItems(model.getKorisnici());

        // Dodavanje ChangeListener-a za promjenu izabranog korisnika
        prikaz.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                imePolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimePolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
            }
            if (newKorisnik == null) {
                imePolje.setText("");
                prezimePolje.setText("");
                emailPolje.setText("");
                korisnickoPolje.setText("");
                lozinkaPolje.setText("");
            }
            else {
                model.setTrenutniKorisnik(new Korisnik());
                prikaz.refresh();

                imePolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimePolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());



            }
        });

    }

    @FXML
    protected void dodajClick() {
        if(model.getTrenutniKorisnik()!=null) {
            imePolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
            prezimePolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
            emailPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
            korisnickoPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
            lozinkaPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        }
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");

        model.getKorisnici().add(noviKorisnik);
        model.setTrenutniKorisnik(noviKorisnik);
        imePolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimePolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        lozinkaPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        prikaz.refresh();
    }

    @FXML
    protected void krajClick() {
        Platform.exit();
    }
}