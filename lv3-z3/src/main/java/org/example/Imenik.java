package org.example;

import java.util.HashMap;
import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> brojevi;
    public Imenik(){
        this.brojevi= new HashMap<String,TelefonskiBroj>();
    }
    public Map<String, TelefonskiBroj> getBrojevi(){return brojevi;}

    public void setBrojevi(Map<String,TelefonskiBroj> brojevi){
        this.brojevi=brojevi;
    }

    /**
     * vlasnik broja
     * @param ime
     * @param broj
     */
    public void dodaj(String ime, TelefonskiBroj broj){this.brojevi.put(ime,broj);}

    public String dajBroj(String ime){
        TelefonskiBroj broj=this.brojevi.get(ime);
        if(broj!=null){
            return broj.ispisi();
        }else {
            return null;
        }
    }
    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            if(entry.getValue().ispisi().equals(broj.ispisi())){
                return entry.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char c){
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()){
            if(entry.getKey().startsWith(String.valueOf(c))){
                builder.append(counter)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            }
            counter++;
        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad g){
        Set<String> results = new TreeSet<String>();
        for(Map.Entry<String,TelefonskiBroj> entry:this.brojevi.entrySet())
        {
            if(jelIzGrada(entry.getValue(),g)){
                results.add(entry.getKey());
            }
        }
        return results;
    }

    private boolean jelIzGrada(TelefonskiBroj broj,Grad g){
        if(broj instanceof  FiksniBroj){
            return g.equals(((FiksniBroj) broj).getGrad());
        }else {
            return false;
        }
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> results = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>(){
            public int compare(TelefonskiBroj o1,TelefonskiBroj o2){return o1.ispisi().compareTo(o2.ispisi());}
        });

        for(Map.Entry<String,TelefonskiBroj> entry : this.brojevi.entrySet())
        {
            if(jelIzGrada(entry.getValue(),g)){
                results.add(entry.getValue());
            }
        }
        return results;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for(Map.Entry<String,TelefonskiBroj> entry : this.brojevi.entrySet()){
            builder.append(counter)
                    .append(". ")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue().ispisi())
                    .append(System.lineSeparator());
            counter++;
        }
        return builder.toString();
    }
}
