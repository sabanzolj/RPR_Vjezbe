package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LaptopDapSerializableFile implements LaptopDao{

    private File file;
    private List<Laptop> laptopi=new ArrayList<>();

    public LaptopDapSerializableFile(File file){
        this.file=file;
        this.laptopi=new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);



    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            ObjectOutputStream ulaz=new ObjectOutputStream(new FileOutputStream(file,true));
            ulaz.writeObject(laptop);

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
            ObjectInputStream ulaz=new ObjectInputStream(new FileInputStream(file));
            ArrayList<Laptop> listaIzDatoteke=new ArrayList<>();
            Object obj;
            while((obj=ulaz.readObject())!=null){
                if(obj instanceof Laptop){
                    listaIzDatoteke.add((Laptop) obj);
                }
            }
            laptopi=listaIzDatoteke;
        }
        catch (EOFException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException | FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return laptopi;
    }


}
