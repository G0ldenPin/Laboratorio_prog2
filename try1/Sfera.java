package Simulazione.try1;

public class Sfera extends Contenitore{
//attributi
    public final double raggio;

//costruttore
    public Sfera(double raggio, String liquido, double qty, double capacity){
        this.raggio = raggio;
        super(liquido, qty, capacity);
    }

    public String toString(){
        return ("--- \n" + "tipo: sfera \n" + "raggio: " + this.raggio + "\n liquido: " + this.liquido + "\n quantità: " + this.qty + "\n capacita: " + this.capacity);
    }
}
