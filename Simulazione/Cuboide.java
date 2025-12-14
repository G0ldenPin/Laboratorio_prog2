public class Cuboide extends Contenitore{
    //attributi
    public final double a;
    public final double b;
    public final double c;

//costruttore
    public Cuboide(double a, double b, double c, String liquido, double qty) {
        super(a * b * c, liquido, qty);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double volume(){
        return (this.a * this.b * this.c);
    }

    @Override
    public String toString() {
        return "Cuboide - a: " + a + " b: " + b + " c: " + c + "\n\t(capienza: " + volume + " liquido: " + liquido + " qty: " + qty + ")";
    }
}