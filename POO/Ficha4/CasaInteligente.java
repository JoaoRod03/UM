import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class CasaInteligente {
    private List <Lampada> lamplist;

    public CasaInteligente(){
        this.lamplist = new ArrayList<>();
    }

    public CasaInteligente(CasaInteligente x) {
        this.lamplist = x.getLamps();
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public List<Lampada> getLamps(){
        List<Lampada> res = new ArrayList<>();
        for (Lampada l : this.lamplist){
            res.put(l.clone());
        }
        return res;
    }

    public void setLamps(List <Lampada> lampadas){
        this.lamplist = lampadas;
    }

    public void addLampada(Lampada l){
        this.lamplist.add(l);
    }    

    public void ligaLampadaNormal(int index){
        lamplist.get(index).lampON();
    }

    public void ligaLampadaEco(int index){
        lamplist.get(index).lampECO();
    }


    public int qtEmEco(){
        int res = 0;
    
        for (Lampada l : this.lamplist){
            if(l.getModo() == Lampada.Mode.ECO) res++;
        }

        return res;
    }

    public void removeLampada(int index){
        this.lamplist.remove(this.lamplist.get(index));
    }

    public void ligaTodasEco(){
        for(Lampada l : this.lamplist) {
            l.lampECO();
        }
    }

    public void ligaTodasMax(){
        for(Lampada l : this.lamplist) {
            l.lampON();
        }
    }

    public double consumoTotal(){
        double res = 0;
        for(Lampada l : this.lamplist) {
            res += l.getConsumoTotal();
        }
        return res;
    }

    public Lampada maisGastadora(){
        Lampada res = new Lampada();
        res.setConsumoTotal(0);
        for (Lampada l : this.lamplist){
            if (l.getConsumoTotal() > res.getConsumoTotal()) res = l;
        }
        return res; 
    }

    public Set<Lampada> lampadasEmModoEco(){
        Set <Lampada> res = new HashSet<Lampada>();
        for (Lampada l : this.lamplist){
            if (l.getModo() == Lampada.Mode.ECO) res.add(l.clone());
        }
        return res;
    }

    public void reset(){
        for (Lampada l : this.lamplist){
            l.resetTemp();
        }
    }

    public Set<Lampada> podiumEconomia() {
        Set<Lampada> res = new HashSet<>();
        Lampada lamp1 = new Lampada();
        double cons1 = Double.MAX_VALUE;
        Lampada lamp2 = new Lampada();
        double cons2 = Double.MAX_VALUE;
        Lampada lamp3 = new Lampada();    
        double cons3 = Double.MAX_VALUE;
        
        for (Lampada l : this.lamplist) {
            if (l.getConsumoEco() < cons1) {
                Lampada temp = lamp1;
                lamp1 = l;
                lamp2 = temp;
            }
            else if (l.getConsumoEco() < cons2) {
                Lampada temp = lamp2;
                lamp2 = l;
                lamp3 = temp;
            }
            else if (l.getConsumoEco() < cons3) lamp3 = l;
        }
        
        res.add(lamp1);
        res.add(lamp2);
        res.add(lamp3);
        return res;
    }
}
