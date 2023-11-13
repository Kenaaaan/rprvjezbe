package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File fajl;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(String putanja) {
        this.fajl = new File(putanja);
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (FileWriter fileWriter = new FileWriter(fajl, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = xmlMapper.writeValueAsString(laptop);
            bufferedWriter.write(xmlString);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException();
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> listaIzDatoteke = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fajl))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                XmlMapper xmlMapper = new XmlMapper();
                Laptop laptop = xmlMapper.readValue(line, Laptop.class);
                listaIzDatoteke.add(laptop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaIzDatoteke;
    }
}