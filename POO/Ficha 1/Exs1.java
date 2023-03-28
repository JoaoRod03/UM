package Ficha1;
import java.time.LocalDate;
import java.lang.Math;

public class Exs1 {
    /* 
    public String diaDaSemana (int a, int b, int c) {

        LocalDate given = LocalDate.of(c, b, a);


    }
*/

    public String somaDias (String a) {

        String dia1s = a.substring(0,2);
        int dia1i = Integer.parseInt(dia1s);
        String hora1s = a.substring(4,6);
        int hora1i = Integer.parseInt(hora1s);
        String min1s = a.substring(8,10);
        int min1i = Integer.parseInt(min1s);
        String seg1s = a.substring(12,14);
        int seg1i = Integer.parseInt(seg1s);
        String dia2s = a.substring(16,18);
        int dia2i = Integer.parseInt(dia2s);
        String hora2s = a.substring(20,22);
        int hora2i = Integer.parseInt(hora2s);
        String min2s = a.substring(24,26);
        int min2i = Integer.parseInt(min2s);
        String seg2s = a.substring(28,30);
        int seg2i = Integer.parseInt(seg2s);

        int diaf=0, horaf=0, minf=0, segf=0;

        segf =seg1i + seg2i;
        if (segf >= 60) {segf = segf % 60 ; minf+=1;}
        minf = minf + min1i + min2i;
        if (minf >= 60) {minf = minf % 60 ; horaf+=1;}
        horaf = horaf + hora1i + hora2i;
        if (horaf >= 24) {horaf = horaf % 24 ; diaf+=1;}
        diaf = diaf + dia1i + dia2i;

        return (diaf + "D " + horaf + "H " + minf + "M " + segf + "S");

    }

    


}
