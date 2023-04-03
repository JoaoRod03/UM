import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GestaoEncomendas {
    private Map<Integer,EncEficiente> encomendas;

    public GestaoEncomendas(){
        encomendas = new HashMap<>();
    }

    public GestaoEncomendas(GestaoEncomendas a){
        this.encomendas = a.getEncomendas();
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    public Map<Integer,EncEficiente> getEncomendas(){
        Map<Integer,EncEficiente> res = new HashMap<Integer,EncEficiente>();
        for (Integer temp : this.encomendas.keySet()){
            res.put(temp, this.encomendas.get(temp).clone());
        }
        return res;
    }

    public void setEncomendas(Map<Integer,EncEficiente> map){
        Map<Integer,EncEficiente> res = new HashMap<Integer,EncEficiente>();
        for (Integer temp : map.keySet()){
            res.put(temp, map.get(temp).clone());
        }
        this.encomendas = res;
    }

    public Set<Integer> todosCodigosEnc(){
        return this.encomendas.keySet();
    }

    public void addEncomenda(EncEficiente enc) {
        this.encomendas.put(enc.getNumero(), enc.clone());
    }

    public EncEficiente getEncomenda(Integer codEnc){
        return this.encomendas.get(codEnc).clone();
    }

    public void removeEncomenda(Integer codEnc){
        this.encomendas.remove(codEnc);
    }

    public Integer encomendaComMaisProdutos(){
        int n = 0, cod = 0;
        for (EncEficiente temp : this.encomendas.values()){
            if (temp.numeroTotalProdutos() > n){
                n = temp.numeroTotalProdutos();
                cod = temp.getNumero();
            }
        }
        return cod;
    }

    public Set<Integer> encomendasComProduto(String codProd){
        Set<Integer> res = new HashSet<>();
        for (Integer temp : this.encomendas.keySet()){
            EncEficiente encomenda = this.encomendas.get(temp);
            if (encomenda.existeProdutoEncomenda(codProd)){
                res.add(temp);
            }
        }
        return res;
    }

    public Set<Integer> encomendasAposData(LocalDate d){
        Set<Integer> res = new HashSet<>();
        for (Integer temp : this.encomendas.keySet()){
            EncEficiente encomenda = this.encomendas.get(temp);
            if (encomenda.getData().isAfter(d)){
                res.add(temp);
            }
        }
        return res;
    }

    public EncEficiente encomendaMaiorValor(){
        EncEficiente res = new EncEficiente();
        double valor = 0;
        for (EncEficiente temp : this.encomendas.values()){
            if(temp.calculaValorTotal() > valor){
                res = temp;
                valor = res.calculaValorTotal();
            }
        }
        return res.clone();
    }
    
    public Map<String,List<Integer>> encomendasDeProduto() {
        Map<String,List<Integer>> res = new HashMap<>();

        for(EncEficiente temp : this.encomendas.values()) {
            for(LinhaEncomenda linha : temp.getLinhas()) {
                String prod = linha.getReferencia();
                if(res.containsKey(prod)){
                    res.get(prod).add(temp.getNumero());
                }
                else {
                    List<Integer> x = new ArrayList<>();
                    x.add(temp.getNumero());
                    res.put(prod, x);
                }
            }
        }
        return res;
    }

}
