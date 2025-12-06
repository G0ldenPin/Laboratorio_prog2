public class Razionale{
//OVERVIEW: la classe modella un numero razionale e restituisce il rapporto numeratore/denominatore in forma ridotta

    //attributi
    public int numeratore;
    public int denominatore;

    //costruttori
    public Razionale(int num, int den) {
        this.numeratore = num;
        this.denominatore = den;
    }

    //metodi
    public getValue() {
        
    }

    public double valore() throws new ArithmeticException {
        if (this.denominatore == 0) {
            throw new ArithmeticException("Denominatore uguale a zero");
        } else {
            return this.numeratore / this.denominatore;
        }
    }

    public static void main(String args[]) throws new ArithmeticException {
        int 
        Razionale r = new Razionale(3, 4);
       
    }

}