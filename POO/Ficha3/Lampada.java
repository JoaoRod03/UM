public class Lampada {
    public enum Mode {
        ON,
        OFF,
        ECO
    }

    private Mode mode;

    private double cons_on;    // Consumo, por milissegundo, no modo on
    private double cons_eco;   // Consumo, por milissegundo, no modo eco
    private double cons_total; // Consumo total
    private double cons_temp;  // Consumo temporário
    private long mil_init;        // Milissegundo inicial

    public Lampada() {
        this.mode = Mode.OFF;
        this.cons_eco = 1;
        this.cons_on = 2;
        this.cons_total = 0;
        this.cons_temp = 0;
        this.mil_init = System.currentTimeMillis();
    }

    public Lampada(Lampada l){
        this.mode = l.getModo();
        this.cons_eco = l.getConsumoEco();
        this.cons_on = l.getConsumoOn();
        this.cons_total = l.getConsumoTotal();
        this.cons_temp = l.getConsumoTemp();
        this.mil_init = l.getMil();
    }

    public Lampada(Mode modo, double cons_eco, double cons_on, double cons_total, double cons_temp) {
        this.cons_eco = cons_eco;
        this.cons_on = cons_on;
        this.mode = modo;
        this.cons_total = cons_total;
        this.cons_temp = cons_temp;
        this.mil_init = System.currentTimeMillis();
    }

    public Lampada clone(){
        return new Lampada(this);
    }

    public Mode getModo() {
        return this.mode;
    }

    public double getConsumoEco(){
        return this.cons_eco;
    }

    public double getConsumoOn(){
        return this.cons_on;
    }

    public double getConsumoTotal() {
        return this.cons_total;
    }

    public double getConsumoTemp() {
        return this.cons_temp;
    }

    public void setModo(Mode m) {
        this.mode = m;
    }

    public long getMil() {
        return this.mil_init;
    }

    public void setConsumoEco(double x){
        this.cons_eco = x;
    }

    public void setConsumoOn(double x){
        this.cons_on = x;
    }
   
    public void setConsumoTotal(double x){
        this.cons_total = x;
    }   

    public void setConsumoTemp(double x){
        this.cons_temp = x;
    }

    public void lampON() {
        this.atualizaConsumo();
        this.mode = Mode.ON;
    }

    public void lampOFF() {
        this.atualizaConsumo();
        this.mode = Mode.OFF;
    }

    public void lampECO() {
        this.atualizaConsumo();
        this.mode = Mode.ECO;
    }

    public void resetTemp(){
        this.atualizaConsumo();
        this.cons_temp = 0;
    }

    public double periodoConsumo(){
        atualizaConsumo();
        return cons_temp;
    }
    public double totalConsumo() {
        atualizaConsumo();
        return cons_total;
    }

    private void atualizaConsumo() {
        long periodo = System.currentTimeMillis() - this.mil_init;

        if(this.mode == Mode.ON) {
            this.cons_total += cons_on *periodo;
            this.cons_temp += cons_on *periodo;
        } else if(this.mode == Mode.ECO) {
            this.cons_total += cons_eco *periodo;
            this.cons_temp += cons_eco *periodo;
        }

        this.mil_init = System.currentTimeMillis();
    }

}
