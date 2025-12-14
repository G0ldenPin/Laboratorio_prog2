import java.lang.Math;

public class Sfera extends Contenitore {
    //attributi
    public final double raggio;

    //costruttore
    public Sfera(double raggio, String liquido, double qty){
        super((4.0/3.0) * Math.PI * Math.pow(raggio, 3), liquido, qty);
        this.raggio = raggio;
    }

    @Override
    public double volume(){
        return (4.0/3.0) * Math.PI * Math.pow(raggio, 3);
    }

    @Override
    public String toString() {
        return "Sfera - r: " + raggio + "\n\t(capienza: " + volume + " liquido: " + liquido + " qty: " + qty + ")";
    }
}