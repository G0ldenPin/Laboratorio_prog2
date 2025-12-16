package Simulazione.try1;

public class Cuboide extends Contenitore{
//attributi
    public final double latoA;
    public final double latoB;
    public final double latoC;

    public Cuboide(double latoA, double latoB, double latoC, String liquido, double qty, double capacity) {
      
        this.latoA = latoA;
        this.latoB = latoB;
        this.latoC = latoC;

        super(liquido, qty, capacity);
    }

    public String toString(){
        return ("--- \n" + "tipo: cuboide \n" + "lato a: " + this.latoA +" \n lato b: " + this.latoB + "\n lato c: " + this.latoC + "\n liquido: " + this.liquido + "\n capacità: " + this.capacity);
    }
}
