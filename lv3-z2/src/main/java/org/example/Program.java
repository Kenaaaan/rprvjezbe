package org.example;

import java.util.Scanner;
import java.util.Set;
public class Program {
    public static Scanner scanner = new Scanner(System.in);
    public static Imenik imenik = new Imenik();

    public static void main(String[] args){
        popuniPodatke();

        while(true){
            System.out.println("Unesite komandu [dpdaj,dajBroj, dajIme, naSlovo, izGrada,izGradaBrojevi, imenik, izlaz");
            String command = scanner.nextLine();
            switch(command){
                case "dodaj":
                    dodajBroj();
                    break;
                case "dajIme":
                    dajIme();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGradaBrojevi();
                    break;
                case "imenik":
                    ispisiImenik();
                    break;
                case "dajBroj":
                    dajBroj();
                case "izlaz":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pogresna komanda");
            }

        }
    }
    private static void izGradaBrojevi(){
        System.out.print("Unesite ime grada: ");
        String grad = scanner.nextLine();
        try{
            Grad g = Grad.valueOf(grad);
            Set<TelefonskiBroj> response = imenik.izGradaBrojevi(g);
            for(TelefonskiBroj b: response) {
                System.out.println(b.ispisi());
            }
        }catch(Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }


    private static void izGrada(){
        System.out.println("Unesite ime grada");
        String grad = scanner.nextLine();
        try{
            Grad g = Grad.valueOf(grad);
            Set<String> response = imenik.izGrada(g);
            System.out.println(response);
        }catch(Exception e){
            System.out.println("pogresan grad");
            return;
        }
    }

    private static void naSlovo(){
        System.out.println("Unesite prvo slovo imena: ");
        String c = scanner.nextLine();
        String response = imenik.naSlovo(c.toCharArray()[0]);
        System.out.println(response);
    }

    private static void dajIme(){
        TelefonskiBroj br = unesiBrojTelefona();
        String ime = imenik.dajIme(br);
        if(ime == null){
            System.out.println("Ne postoji u imeniku");
        }else {
            System.out.println("Vlasnik broja " + br.ispisi() + " je " + ime);
        }
    }
    private static TelefonskiBroj unesiBrojTelefona(){
        System.out.println("Unesite tip broja");
        String type = scanner.nextLine();
        switch (type){
            case "fiksni":
                System.out.println("Unesite pozivni: ");
                String pozivni = scanner.nextLine();
                System.out.println("Unesite broj");
                String broj=scanner.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni),broj);
            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza = scanner.nextInt();
                System.out.println("Unesite broj");
                String mobbroj=scanner.nextLine();
                return new MobilniBroj(mreza, mobbroj);
            case "medunarodni":
                System.out.println("Unesite kod drzave [+387]: ");
                String kod = scanner.nextLine();
                System.out.println("Unesite broj");
                String medbroj=scanner.nextLine();
                return new MedunarodniBroj(kod,medbroj);
        }
        return null;
    }
    private static void dodajBroj(){
        System.out.println("Unesite ime");
        String name = scanner.nextLine();
        TelefonskiBroj br = unesiBrojTelefona();
        imenik.dodaj(name,br);
    }

    private static void ispisiImenik(){System.out.println(imenik.toString());}

    private static void dajBroj(){
        System.out.println("Unesite ime");
        String ime = scanner.nextLine();
        String rez = imenik.dajBroj(ime);
        System.out.println(rez==null ? "nema u imeniku" : rez);
    }

    private static void popuniPodatke(){
        imenik.dodaj("Kenan", new FiksniBroj(Grad.BIHAC,"258 068"));
    }




}




















