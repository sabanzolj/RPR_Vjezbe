package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoXMLFile implements LaptopDao{

    private File file;
    private List<Laptop> laptopi=new ArrayList<>();

    public LaptopDaoXMLFile(File file) {
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
            XmlMapper ulaz=new XmlMapper();
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
            XmlMapper xmlMapper = new XmlMapper();
            laptopi = xmlMapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laptopi;
    }
}
