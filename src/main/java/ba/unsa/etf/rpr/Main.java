package ba.unsa.etf.rpr;
import java.util.List;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

        System.out.println(ispisiGradove());

        glavniGrad();
    }

    public static String ispisiGradove() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        StringBuilder rezultat = new StringBuilder();

        for (Grad grad : geografijaDAO.gradovi()) {
            Drzava drzava = geografijaDAO.nadjiDrzavuPoId(grad.getDrzava());
            rezultat.append(grad.getNaziv())
                    .append(" (").append(drzava != null ? drzava.getNaziv() : "Nepoznata država").append(") - ")
                    .append(grad.getBrojStanovnika())
                    .append("\n");
        }

        return rezultat.toString();
    }

    public static void glavniGrad() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite naziv države:");
        String drzavaNaziv = scanner.nextLine();

        Grad glavniGrad = geografijaDAO.glavniGrad(drzavaNaziv);

        if (glavniGrad != null) {
            System.out.println("Glavni grad države " + drzavaNaziv + " je " + glavniGrad.getNaziv());
        } else {
            System.out.println("Nepostojeća država");
        }
    }
}