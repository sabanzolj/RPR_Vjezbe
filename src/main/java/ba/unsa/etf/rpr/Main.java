package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InformacijeOStudentu student=new InformacijeOStudentu();
        student.setIme("Saban");
        student.setPrezime("Zolj");
        student.setGodinaStudija("II");
        student.setBrojInexa("19333");

        InformacijeONastavniku nastavnik=new InformacijeONastavniku();
        nastavnik.setIme("Murat");
        nastavnik.setPrezime("Salaka");
        nastavnik.setTitula("dipl.ing");

        Predmet predmet=new Predmet();
        predmet.setNazivPredmeta("Osnove elektrotehnike");
        predmet.setOpisPredmeta("Na ovom predmetu se izucavaju osnovni pojmovi koji se koriste u elektrotehnici");

        List<Predstavljiva> lista=new ArrayList<>();
        lista.add(student);
        lista.add(nastavnik);
        lista.add(predmet);

        KolekcijaPoruka kolekcija=new KolekcijaPoruka(lista);
        List<String> porukeListe=kolekcija.getPoruke();

        System.out.println("Poruke koje se nalaze u kolekciji su: ");
        for(String poruka:porukeListe){
            System.out.println(poruka);
        }

        Scanner ulaz=new Scanner(System.in);

        System.out.println("Unesite ocjenu za predmet: ");
        int novaOcjena=ulaz.nextInt();
        Ocjena ocjenaPredmeta=predmet.ocijeni(novaOcjena);

        System.out.println("Ocjena predmeta je: "+ocjenaPredmeta.getOcjena());
    }
}