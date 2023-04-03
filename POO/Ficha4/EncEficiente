import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;

public class EncEficiente {
    private String nome;
    private int nif;
    private String morada;
    private int numero;
    private LocalDate data;
    private List<LinhaEncomenda> linhas;

    public EncEficiente () {
        this.nome = "";
        this.nif = 0;
        this.morada = "";
        this.numero = 0;
        this.data = LocalDate.now();
        this.linhas= new ArrayList<>() ;
    }
    
    public EncEficiente (String nome, int nif, String morada, int numero, LocalDate data, ArrayList<LinhaEncomenda> linhas) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numero = numero;
        this.data = data;
        this.linhas= new ArrayList<>(linhas) ;
    }
    
    public EncEficiente (EncEficiente enc) {
        this.nome = enc.getNome();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.numero = enc.getNumero();
        this.data = enc.getData();
        this.linhas= enc.getLinhas() ;
    }
    
    public String getNome() {
        return this.nome;
    }

    public int getNif() {
        return this.nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public int getNumero() {
        return this.numero;
    }

    public LocalDate getData() {
        return this.data;
    }

    public List<LinhaEncomenda> getLinhas() {
        return this.linhas;
    }
    
    public double calculaValorTotal() {
        double res = 0;
        for (LinhaEncomenda l : this.linhas) {
            res += l.calculaValorLinhaEnc();
        }
        return res;
    }

    public double calculaValorDesconto() {
        int res = 0;
        for (LinhaEncomenda l : this.linhas) {
            res += l.getDesconto();
        }
        return res;
    }

    public int numeroTotalProdutos() {
        int res = 0;
        for (LinhaEncomenda l : this.linhas) {
            res += l.getQuantidade();
        }
        return res;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        boolean res = false;
        for (LinhaEncomenda l : this.linhas) {
            if (l.getReferencia() == refProduto) res = true;
        }
        return res;
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha);
    }

    public void removeProduto(String codProd) {
        Iterator <LinhaEncomenda> itr = linhas.iterator();  
        
        while (itr.hasNext()) { 
            LinhaEncomenda a = itr.next();
            if (a.getReferencia().equals(codProd)) itr.remove();
        }
    }
}
