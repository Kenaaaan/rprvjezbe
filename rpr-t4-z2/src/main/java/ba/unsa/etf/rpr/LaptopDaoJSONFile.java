package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private File fajl;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(String putanja) {
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

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(laptop);
            bufferedWriter.write(jsonString);
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
                ObjectMapper objectMapper = new ObjectMapper();
                Laptop laptop = objectMapper.readValue(line, Laptop.class);
                listaIzDatoteke.add(laptop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaIzDatoteke;
    }
}