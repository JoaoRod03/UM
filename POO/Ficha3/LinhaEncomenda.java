public class LinhaEncomenda {

    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;

//A)

    public LinhaEncomenda () {
        this.referencia = "";
        this.descricao = "";
        this.preco = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
    }

    public LinhaEncomenda (String referencia, String descricao, double preco, int quantidade, double imposto, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    } 

    public LinhaEncomenda (LinhaEncomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.preco = linha.getPreco();
        this.quantidade = linha.getQuantidade();
        this.imposto = linha.getImposto();
        this.desconto = linha.getDesconto();
    }

    public String getReferencia() {
        return this.referencia;
    } 

    public String getDescricao() {
        return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    } 

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LinhaEncomenda clone() {
        LinhaEncomenda linha = new LinhaEncomenda(this);
        return linha;
    }

//B)

    public double calculaValorLinhaEnc() {
        
        double res;
        res = this.quantidade * this.preco;
        res-= res * this.desconto;
        res*= 1+ this.imposto;
        return res;
    }

//C)

    public double calculaValorDesconto() {

        double res;
        res = this.quantidade * this.preco * this.desconto;
        return res;
    }

    public boolean equals(Object obj) {
        if(obj==this) 
           return true;
        if(obj==null || obj.getClass() != this.getClass()) 
           return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getReferencia().equals(this.referencia) &&
               le.getDescricao().equals(this.descricao) && 
               le.getPreco() == this.preco && 
               le.getQuantidade() == this.quantidade &&
               le.getDesconto() == this.desconto &&
               le.getImposto() == this.imposto;
    }

}
