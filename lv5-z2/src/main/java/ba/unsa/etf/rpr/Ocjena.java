package ba.unsa.etf.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    public void setOcjena(int o) throws Exception {
        if(o>0 && o<10)
            this.ocjena=0;
        throw new Exception("nije validna ocjena");
    }

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        this.ocjena = ocjena;
    }
}
