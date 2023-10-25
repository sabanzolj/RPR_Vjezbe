package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) {
        Sat sat=new Sat(15,30,45);
        sat.Ispisi();
        sat.Sljedeci();
        sat.Ispisi();
        sat.PomjeriZa(-48);
        sat.Ispisi();
        sat.Postavi(0,0,0);
        sat.Ispisi();
    }
}