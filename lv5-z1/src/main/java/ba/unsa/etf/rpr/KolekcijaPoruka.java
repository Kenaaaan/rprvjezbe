package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaPoruka implements Predstavljiv{
    private ArrayList<String> poruke;
    public String predstavi(){
        StringBuilder rez= new StringBuilder();
        for(int i = 0;i<poruke.size();i++){
            rez.append(poruke.get(i));
        }
        return rez.toString();
    }
    public ArrayList<String> getPoruke() {
        return poruke;
    }
    public KolekcijaPoruka(ArrayList<Predstavljiv> Poruke) {
        for(var x:Poruke){
            poruke.add(x.predstavi());
        }
    }
}
