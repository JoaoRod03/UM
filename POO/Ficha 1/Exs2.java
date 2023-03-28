package Ficha1;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Exs2 {

    public double celsiusparafarenheit(double graus){
        return graus * 1.8 + 32;
    }

    public int maximoNumeros(int a, int b){
        if (a > b) return a; else return b; 
    }

    public String criaDescricaoConta(String nome, double saldo){

        return "Nome: " + nome + ", saldo: " + saldo;

    }

    public double eurosParaLibras(double valor, double taxaConversao){

        return valor * taxaConversao ;

    }

    public String ordemCrescente(int c, int d){

        int maior, menor;       
        if (c < d) {menor = c ; maior = d;}
            else {menor = d;maior = c;}
        
        double c1 = c , d2 = d;
        double media;
        media = (c1 + d2)/2; 

        return "Menor: " + menor + ", Maior: " + maior +", média: " + media;

    }

    public long factorial(int num) {

        long v = num ;
        long r = 1 ;
        while (v >= 1){
            r *= v;
            v--;
        }

        return r;
    }

    public long tempoGasto() {

        LocalDateTime currentDateTime1 = LocalDateTime.now();
        
        int v2 = 5000 ;
        int r2 = 1 ;
        while (v2 >= 1){
            r2 *= v2;
            v2--;
        }

        LocalDateTime currentDateTime2 = LocalDateTime.now();


        LocalDateTime fromTemp = LocalDateTime.from(currentDateTime1);
        long s = fromTemp.until(currentDateTime2, ChronoUnit.MILLIS);
        
        return s;
    
    }

} 