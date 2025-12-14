import java.lang.Math;

public class Cilindro extends Contenitore{
    //attributi
    public final double altezza;
    public final double raggio;

//costruttore
    public Cilindro(double altezza, double raggio, String liquido, double qty){
        super(altezza * Math.PI * Math.pow(raggio, 2), liquido, qty);
        this.altezza = altezza;
        this.raggio = raggio;
    }

    @Override
    public double volume(){
        return (this.altezza * Math.PI * Math.pow(raggio, 2));
    }

    @Override
    public String toString() {
        return "Cilindro - h: " + altezza + " r: " + raggio + "\n\t(capienza: " + volume + " liquido: " + liquido + " qty: " + qty + ")";
    }
}