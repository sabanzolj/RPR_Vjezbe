package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Set;

public class Program {

    public static Scanner ulaz=new Scanner(System.in);
    public static Imenik imenik=new Imenik();


    public static void main(String[] args){


        while (true){
            System.out.println("Unesite komandu [dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, imenik, izlaz]: ");
            String command=ulaz.nextLine();

            switch (command){
                case "dodaj":
                    dodajBroj();
                break;

                case "dajBroj":
                    dajBroj();
                break;

                case "dajIme":
                    dajIme();
                    break;

                case "naSlovo":
                    naSlovo();
                break;

                case "izGrada":
                    izGrada();
                break;

                case "izGradaBrojevi":
                    izGradaBrojevi();
                break;

                case "imenik":
                    ispisiImenik();
                break;

                case "izlaz":
                    System.exit(0);
                break;

                default:
                    System.out.println("Pogresna komanda");

            }
        }

    }

    private static TelefonskiBroj unesiBrojTelefona(){
        System.out.println("Unesi tip broja[fiksni,mobilni,medjunarodni]: ");
        String tip_broja=ulaz.nextLine();

        switch (tip_broja){
            case "fiksni":
                System.out.println("Unesite pozivni broj: ");
                String pozivni=ulaz.nextLine();
                System.out.println("Unesite broj: ");
                String broj=ulaz.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni),broj);

            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza=ulaz.nextInt();
                ulaz.nextLine();
                System.out.println("Unesite broj: ");
                String mobBroj=ulaz.nextLine();
                return new MobilniBroj(mreza,mobBroj);


            case "medjunarodni":
                System.out.println("Unesite drzavu[+387]: ");
                String kod=ulaz.nextLine();
                System.out.println("Unesite broj: ");
                String medjBroj=ulaz.nextLine();
                return new MedunarodniBroj(kod,medjBroj);





        }
        return null;
    }

    private static void dodajBroj(){
        System.out.println("Unesite ime: ");
        String ime_korisnika=ulaz.nextLine();
        TelefonskiBroj broj_korisnika=unesiBrojTelefona();
        imenik.dodaj(ime_korisnika,broj_korisnika);

    }

    private static void dajBroj(){
        System.out.println("Unesite ime: ");
        String ime=ulaz.nextLine();
        String rezultat=imenik.dajBroj(ime);
        System.out.println(rezultat==null ? "nema u imeniku":rezultat);
    }

    private static void dajIme(){
        TelefonskiBroj broj=unesiBrojTelefona();
        String osoba=imenik.dajIme(broj);
        System.out.println(osoba==null ? "nema osobe u imeniku":"Vlasnik broja "+broj.ispisi()+" je "+osoba);
    }

    private static void naSlovo(){
        System.out.println("Unesite prvo slovo imena: ");
        String slovo=ulaz.nextLine();
        String rezultat=imenik.naSlovo(slovo.toCharArray()[0]);
        System.out.println(rezultat);

    }

    private static void izGrada(){
        System.out.println("Unesite ime grada: ");
        String ime_grada=ulaz.nextLine();
        try {
            Grad g=Grad.valueOf(ime_grada);
            Set<String> rezultat=imenik.izGrada(g);
            System.out.println(rezultat);
        }
        catch (Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }

    private static void izGradaBrojevi(){
        System.out.println("Unesite ime grada: ");
        String ime_grada=ulaz.nextLine();
        try {
            Grad g=Grad.valueOf(ime_grada);
            Set<TelefonskiBroj> rezultat=imenik.izGradaBrojevi(g);
            for(TelefonskiBroj br:rezultat){
                System.out.println(br.ispisi());
            }
        }
        catch (Exception e){
            System.out.println("Pogresan grad");
            return;
        }
    }

    private static void ispisiImenik(){
        System.out.println(imenik.toString());
    }


}
