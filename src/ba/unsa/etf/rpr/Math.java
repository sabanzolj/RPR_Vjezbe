package ba.unsa.etf.rpr;

public class Math {
    public static double IzdracunajSinus(double x){
        return java.lang.Math.sin(x);
    }

    public static long Faktorijel(int x){
        if(x==0 || x==1)return 1;
        long f=1;
        for(int i=2;i<=x;i++){
            f*=i;
        }
        return f;
    }
}