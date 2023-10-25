package ba.unsa.etf.rpr;


public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Nedovoljan broj argumenata. Upotreba: java -jar lv2.z1.jar [funkcija] [argument]");
        } else {
            try {
                String funkcija = args[0];
                double ulaz = Double.parseDouble(args[1]);
                if ("sinus".equals(funkcija)) {
                    System.out.println("sinus(" + ulaz + ") = " + Math.IzdracunajSinus(ulaz));
                } else if ("faktorijel".equals(funkcija)) {
                    if (ulaz >= 0 && ulaz == (int) ulaz) {
                        System.out.println("faktorijel(" + ulaz + ") = " + Math.Faktorijel((int) ulaz));
                    } else {
                        System.err.println("Nije validan drugi argument, mora biti pozitivan cijeli broj.");
                    }
                } else {
                    System.err.println("Nepodržana funkcija: " + funkcija);
                }

            } catch (NumberFormatException e) {
                System.err.println("Nije validan drugi argument, mora biti broj.");
            }
        }
    }
}