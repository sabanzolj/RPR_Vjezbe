package ba.unsa.etf.rpr;

import java.util.List;

public class MatematickeFunkcije {

    public static Double min(List<Double> lista){
        double min=Double.MAX_VALUE;
        for(Double broj:lista){
            if(broj<min)min=broj;
        }
        return min;
    }

    public static Double max(List<Double> lista){
        double max=Double.MIN_VALUE;
        for(Double broj:lista){
            if(broj>max)max=broj;
        }
        return max;
    }

    public static Double mean(List<Double> lista){
        double suma=0;
        int brojac=0;
        for(Double broj:lista){
            suma+=broj;
            brojac++;
        }

        return suma/brojac;

    }

    public static Double standDev(List<Double> lista){
        double mean=mean(lista);
        double var=0;
        for(Double broj:lista){
            var+=Math.pow(broj-mean,2);
        }
        return Math.sqrt(var/(lista.size()-1));
    }
}
