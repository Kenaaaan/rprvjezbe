package ba.unsa.etf.rpr;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoTest {

    private static final String TEST_FILE_NAME = "test_laptops.txt";

    @BeforeEach
    void setUp() {
        // Brisanje test fajla pre svakog testa
        File testFile = new File(TEST_FILE_NAME);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @AfterEach
    void tearDown() {
        // Brisanje test fajla posle svakog testa
        File testFile = new File(TEST_FILE_NAME);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testDodajLaptopUListu() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        Laptop laptop1 = new Laptop("Dell", "Inspiron", 1200.0, 16, 512, 256, "Intel i7", "Nvidia GTX 1660", 15.6);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 900.0, 8, 256, 0, "AMD Ryzen 5", "AMD Radeon", 14.0);

        dao.dodajLaptopUListu(laptop1);
        dao.dodajLaptopUListu(laptop2);

        ArrayList<Laptop> lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(laptop1));
        assertTrue(lista.contains(laptop2));
    }

    @Test
    void testDodajLaptopUFile() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        Laptop laptop1 = new Laptop("Lenovo", "ThinkPad", 1500.0, 16, 512, 512, "Intel i9", "Nvidia RTX 3070", 15.6);
        Laptop laptop2 = new Laptop("Acer", "Aspire", 800.0, 8, 256, 0, "AMD Ryzen 7", "AMD Radeon", 14.0);

        dao.dodajLaptopUFile(laptop1);
        dao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(laptop1));
        assertTrue(lista.contains(laptop2));
    }

    @Test
    void testGetLaptop() throws NeodgovarajuciProcesorException {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        Laptop laptop1 = new Laptop("Apple", "MacBook Pro", 2000.0, 16, 512, 512, "Intel i9", "AMD Radeon Pro", 16.0);
        Laptop laptop2 = new Laptop("Asus", "ROG Strix", 1800.0, 32, 1024, 256, "AMD Ryzen 9", "Nvidia RTX 3080", 17.3);

        dao.dodajLaptopUListu(laptop1);
        dao.dodajLaptopUListu(laptop2);

        Laptop result = dao.getLaptop("Intel i9");

        assertEquals(laptop1, result);
    }

    @Test
    void testGetLaptopException() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        assertThrows(NeodgovarajuciProcesorException.class, () -> dao.getLaptop("NepostojeciProcesor"));
    }

    @Test
    void testNapuniListu() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        Laptop laptop1 = new Laptop("Samsung", "Galaxy Book", 1000.0, 8, 256, 0, "Intel i5", "Intel UHD Graphics", 13.3);
        Laptop laptop2 = new Laptop("Microsoft", "Surface Laptop", 1200.0, 16, 512, 128, "Intel i7", "Intel Iris Plus", 15.0);

        ArrayList<Laptop> novaLista = new ArrayList<>();
        novaLista.add(laptop1);
        novaLista.add(laptop2);

        dao.napuniListu(novaLista);

        ArrayList<Laptop> lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(laptop1));
        assertTrue(lista.contains(laptop2));
    }

    @Test
    void testVratiPodatkeIzDatoteke() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(TEST_FILE_NAME);

        Laptop laptop1 = new Laptop("Toshiba", "Satellite", 800.0, 8, 256, 0, "Intel i3", "Intel HD Graphics", 14.0);
        Laptop laptop2 = new Laptop("Sony", "VAIO", 1000.0, 12, 512, 0, "AMD Ryzen 5", "AMD Radeon", 15.6);

        dao.dodajLaptopUListu(laptop1);
        dao.dodajLaptopUListu(laptop2);

        ArrayList<Laptop> lista = dao.vratiPodatkeIzDatoteke();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(laptop1));
        assertTrue(lista.contains(laptop2));
    }
}
