package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ulaz=new Scanner(System.in);
        List<Double> lista=new ArrayList<Double>();

        while(true){
            System.out.println("Unesite broj ili rijec stop: ");
            String line=ulaz.nextLine();

            if("stop".equalsIgnoreCase(line.trim())){
                break;
            }

            try{
                Double broj=Double.parseDouble(line);
                lista.add(broj);
            }
            catch (Exception e){
                System.out.println("Uneseni string nije broj");
                continue;
            }
        }

        System.out.println("Rezultati: ");
        System.out.println("MIN= "+MatematickeFunkcije.min(lista));
        System.out.println("MAX= "+MatematickeFunkcije.max(lista));
        System.out.println("MEAN= "+MatematickeFunkcije.mean(lista));
        System.out.println("STANDARDNA DEVIJACIJA= "+MatematickeFunkcije.standDev(lista));
    }
}
