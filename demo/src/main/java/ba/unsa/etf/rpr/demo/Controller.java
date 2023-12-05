package ba.unsa.etf.rpr.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    private StringBuilder prvi=new StringBuilder();
    private StringBuilder drugi=new StringBuilder();
    private boolean prije=true;
    private String ispisniString="";
    @FXML
    private Label label_ispis;
    private String operator;

    @FXML
    public void jedanClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"1";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("1");
        }else{
            drugi.append("1");
        }
    }

    @FXML
    public void petClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"5";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("5");
        }else{
            drugi.append("5");
        }
    }

    @FXML
    public void sestClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"6";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("6");
        }else{
            drugi.append("6");
        }
    }

    @FXML
    public void nulaClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"0";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("0");
        }else{
            drugi.append("0");
        }
    }

    @FXML
    public void devetClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"9";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("9");
        }else{
            drugi.append("9");
        }
    }

    @FXML
    public void osamClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"8";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("8");
        }else{
            drugi.append("8");
        }
    }

    @FXML
    public void sedamClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"7";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("7");
        }else{
            drugi.append("7");
        }
    }

    @FXML
    public void cetiriClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"4";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("4");
        }else{
            drugi.append("4");
        }
    }

    @FXML
    public void dvaClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"2";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("2");
        }else{
            drugi.append("2");
        }
    }

    @FXML
    public void triClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+"3";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append("3");
        }else{
            drugi.append("3");
        }
    }

    @FXML
    public void sabiranjeClick(ActionEvent actionEvent) {
        prije=false;
        operator="+";
        //label_ispis.setText("");
        ispisniString="";
    }

    @FXML
    public void jednakoClick(ActionEvent actionEvent) {
        Double a=Double.parseDouble(prvi.toString());
        Double b=Double.parseDouble(drugi.toString());
        Double rez=null;
        switch(operator){
            case "+":
                rez=a+b;
                break;
            case "*":
                rez=a*b;
                break;
            case "/":
                rez=a/b;
                break;
            case "%":
                rez=a%b;
                break;
            default:
                rez=0.;
                break;
        }
         label_ispis.setText(rez.toString());
    }

    @FXML
    public void procenatClick(ActionEvent actionEvent) {
        prije=false;
        operator="%";
        ispisniString="";
    }

    @FXML
    public void dijeljenjeClick(ActionEvent actionEvent) {
        prije=false;
        operator="/";
        ispisniString="";
    }
    @FXML
    public void mnozenjeClick(ActionEvent actionEvent) {
        prije=false;
        operator="*";
        ispisniString="";
    }

    @FXML
    public void minusClick(ActionEvent actionEvent) {
        prije=false;
        operator="-";
        ispisniString="";
    }

    @FXML
    public void tackaClick(ActionEvent actionEvent) {
        ispisniString=ispisniString+".";
        label_ispis.setText(ispisniString);
        if(prije){
            prvi.append(".");
        }else{
            drugi.append(".");
        }
    }
}