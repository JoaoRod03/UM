package Ficha1;
import java.util.Scanner;

public class TestePrograma {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Exs1 ex1 = new Exs1();
        Exs2 ex2 = new Exs2();

        System.out.println("Indique as duas datas");
        String dias = sc.nextLine();
        System.out.println(ex1.somaDias(dias));
        
        System.out.println("Indique a temperatura em Celsius");
        double grausC = sc.nextDouble();
        double grausF = ex2.celsiusparafarenheit(grausC);
        System.out.println(grausF);
    
        System.out.println("Indique os números");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println (ex2.maximoNumeros(n1,n2));

        System.out.println("Indique o nome e o saldo");
        String nome = sc.next();
        double saldo = sc.nextInt();
        System.out.println (ex2.criaDescricaoConta(nome,saldo));

        System.out.println("Indique o valor em euros e a taxa de conversão");
        double valor = sc.nextDouble();
        double taxa = sc.nextDouble();
        System.out.println (ex2.eurosParaLibras(valor,taxa));

        System.out.println("Indique os dois valores");
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();
        System.out.println (ex2.ordemCrescente(n3,n4));
    
    
        System.out.println("Indique o número");
        int n5 = sc.nextInt();
        System.out.println (ex2.factorial(n5));
        
        System.out.println (ex2.tempoGasto());


        sc.close();
    }
}