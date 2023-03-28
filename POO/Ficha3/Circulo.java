import java.lang.Math;

public class Circulo {
    
    private double x;
    private double y;
    private double raio;

    public Circulo () {

        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo (double cx, double cy, double craio) {

        this.x = cx;
        this.y = cy;
        this.raio = craio;
    }

    public Circulo (Circulo circ) {

        this.x = circ.getX();
        this.y = circ.getY();
        this.raio = circ.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double cx){
        this.x = cx;
    }

    public void setY(double cy){
        this.y = cy;
    }

    public void setRaio(double craio){
        this.raio = craio;
    }

    public void alteraCentro(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double calculaArea() {

        double res;
        double raio = getRaio();
        double pi = Math.PI;
        res = (raio * raio) * pi;

        return res;
    }

    public double calculaPerimetro() {

        double res;
        double raio = getRaio();
        double pi = Math.PI;
        res = 2 * pi * raio;
        return res;
    }
}
