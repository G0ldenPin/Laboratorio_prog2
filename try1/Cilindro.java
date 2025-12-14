package Simulazione.try1;

public class Cilindro extends Contenitore{
//attributi
    public final double h;
    public final double r;

//costruttore
    public Cilindro(double r, double h, String liquido, double qty, double capacity){
        this.r = r;
        this.h = h;

        super(liquido, qty, capacity);
    }

    public String toString(){
        return ("--- \n" + "tipo: cilindro \n" + "raggio: " + this.r + "\n altezza: " + this.h + "\n liquido: " + this.liquido + "\n quantità: " + this.qty + "\n capacità: " + this.capacity);
    }
}
