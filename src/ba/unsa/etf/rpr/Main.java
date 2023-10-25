package ba.unsa.etf.rpr;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Unesite prvi cijeli broj: ");
        Scanner ulaz=new Scanner(System.in);
        int a;
        a=ulaz.nextInt();
        System.out.println("Unesite drugi cijeli broj: ");
        int b;
        b=ulaz.nextInt();
        System.out.println("Uneseni cijeli brojevi su: " + a+ " "+b);


    }
}