package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private List<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);

    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        this.laptopi.add(laptop);
        try {
            ObjectMapper ulaz=new ObjectMapper();
            ulaz.enable(SerializationFeature.INDENT_OUTPUT);
            ulaz.writeValue(file,laptopi);

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop laptop:laptopi){
            if(laptop.getProcesor().equals(procesor)){
                return laptop;
            }
        }
        throw new NepostojeciProcesorException("Laptop sa procesorom koji ste trazili ne postoji!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi=laptopi;

    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        try {
            ObjectMapper ulaz=new ObjectMapper();
            laptopi=ulaz.readValue(file,new TypeReference<ArrayList<Laptop>>() {});

        }

        catch (IOException e){
            e.printStackTrace();

        }
        return laptopi;
    }
}
