package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public interface LaptopDao {

    public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop);

    public Laptop getLaptop(String procesor);
    public void napuniListu(ArrayList<Laptop> laptopi);

    public List<Laptop> vratiPodatkeIzDatoteke();


}
