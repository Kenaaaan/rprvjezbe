package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class KolekcijaImenaIPrezimena {
    private ArrayList<String> imena;
    private ArrayList<String> prezimena;
    public int getIndexNajduzegPara(){
        int i=-1;
        for(int k=0;k<imena.size();k++){
                String s1=imena.get(k);
                String s2=prezimena.get(k);
               if((s1+s2).length()>i) {
                   i = k;
               }
        }
        return i;
    }
    public String getImeiPrezime(int i){
        return (imena.get(i)+" "+prezimena.get(i));
    }

    public KolekcijaImenaIPrezimena(ArrayList<String> imena, ArrayList<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }
}
