package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista=new ArrayList<String>();
        lista.add("Kenan Abadzic");
        lista.add("Kristijan Golubovic");
        lista.add("Harun Mioc");
        lista.add("Lagani Laganovicnajduzovic");
        KolekcijaImena kolekcija= new KolekcijaImena();
        kolekcija.setImena(lista);
        Pobjednik p=new Pobjednik(kolekcija);
        System.out.println(p.getIme());//ispisalo je laganog znaci radi :D
        ArrayList<String> imena=new ArrayList<String>();
        ArrayList<String> prezimena=new ArrayList<String>();
        imena.add("Kenan");
        imena.add("Robert");
        imena.add("Cristiano");
        prezimena.add("Abadzic");
        prezimena.add("Lewandowski");
        prezimena.add("Ronaldo");
        imena.add("najduzeimeikad");
        prezimena.add("zavrenlabevohvalaBoguakoovoispise");
        KolekcijaImenaIPrezimena test=new KolekcijaImenaIPrezimena(imena,prezimena);
        System.out.println(test.getImeiPrezime(test.getIndexNajduzegPara()));
    }
}