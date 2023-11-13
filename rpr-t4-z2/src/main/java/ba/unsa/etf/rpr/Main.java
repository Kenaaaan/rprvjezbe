package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testirajLaptopDao(new LaptopDaoSerializableFile("laptops_serializable.txt"));

        testirajLaptopDao(new LaptopDaoJSONFile("laptops_json.json"));

        testirajLaptopDao(new LaptopDaoXMLFile("laptops_xml.xml"));
    }

    private static void testirajLaptopDao(LaptopDao laptopDao) {
        // Dodavanje
        System.out.println("Velicina prije dodavanja: " + laptopDao.vratiPodatkeIzDatoteke().size());
        laptopDao.dodajLaptopUFile(new Laptop("HP", "Omen", 1400.0, 16, 2048, 512, "Ryzen 7 6800", "RTX4050", 16.1));
        laptopDao.dodajLaptopUFile(new Laptop("Acer", "Nitro 5", 1200.0, 16, 1024, 512, "i7 11th gen", "RTX3070", 15.6));
        laptopDao.napuniListu(laptopDao.vratiPodatkeIzDatoteke());
        System.out.println("Velicina nakon dodavanja: " + laptopDao.vratiPodatkeIzDatoteke().size());

        // Broj laptopa ce se stalno povecavati jer koristimo append

        // Citanje datoteke
        ArrayList<Laptop> laptopi = laptopDao.vratiPodatkeIzDatoteke();
        System.out.println("Velicina nakon citanja iz datoteke: " + laptopi.size());
        for (Laptop laptop : laptopi) {
            System.out.println(laptop);
        }

        // Nalazenje procesora
        System.out.println("Velicina prije pretrage: " + laptopi.size());
        try {
            Laptop trazeniLaptop = laptopDao.getLaptop("i7 11th gen");
            System.out.println("Pronadeni laptop: " + trazeniLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println("Nema laptopa sa trazenim procesorom.");
        }
        System.out.println("Velicina nakon pretrage: " + laptopi.size());

    }
}