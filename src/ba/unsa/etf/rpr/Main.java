package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {

    public static int sumaCifara(int n){
        int suma=0;
        while(n!=0){
            suma+=n%10;
            n=n/10;
        }
        return suma;
    }

    public static void main(String[] args) {
        System.out.println("Unesite pozitivan cijeli broj: ");
        Scanner ulaz=new Scanner(System.in);
        int broj=ulaz.nextInt();

        System.out.println("Brojevi koji su djeljivi sa sumom cifara broja "+broj+" su: ");
        for(int i=1;i<=broj;i++){
            if(i%sumaCifara(broj)==0)System.out.print(i+" ");
        }
    }
}