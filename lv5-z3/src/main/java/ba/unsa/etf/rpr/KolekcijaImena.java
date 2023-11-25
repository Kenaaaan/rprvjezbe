package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaImena {
    private ArrayList<String> imena;

    public String getNajduziIme(){
        String rez="";
        for(String s:imena){
            if(s.length()>rez.length()){
                rez=s;
            }
        }
        return rez;
    }

    public ArrayList<String> getImena() {
        return imena;
    }

    public void setImena(ArrayList<String> imena) {
        this.imena = imena;
    }
}
