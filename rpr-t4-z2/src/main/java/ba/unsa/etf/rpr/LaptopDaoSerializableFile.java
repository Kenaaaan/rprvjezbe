package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File fajl;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(String putanja) {
        this.fajl = new File(putanja);
        this.laptopi = new ArrayList<Laptop>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fajl, true))) {
            oos.writeObject(laptop);
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
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fajl))) {
            while (true) {
                try {
                    Laptop laptop = (Laptop) ois.readObject();
                    listaIzDatoteke.add(laptop);
                } catch (EOFException e) {
                    // Završetak čitanja
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaIzDatoteke;
    }

    public void setMockObjectOutputStream(ObjectOutputStream mockObjectOutputStream) {
    }

    public void setMockObjectInputStream(ObjectInputStream mockObjectInputStream) {
    }
}