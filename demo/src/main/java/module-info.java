module ba.unsa.etf.rpr.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.unsa.etf.rpr.demo to javafx.fxml;
    exports ba.unsa.etf.rpr.demo;
}