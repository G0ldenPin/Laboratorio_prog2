import java.util.Scanner;
import java.util.ArrayList;

public abstract class Contenitore extends Vetreria {
//OVERVIEW: la classe modella un contenitore con definita volume e liquido contenuto. Può versare il liquido contenuto in altri contenitori e gestisce i casi eccezionali durante questa azione.

    public abstract double volume();


//attributi
    protected double volume;
    protected String liquido;
    protected double qty;

//costruttore
    public Contenitore(double volume, String liquido, double qty){
        if (qty > volume) {
            throw new CapacityException("La quantità di liquido (" + qty + ") supera la capienza del contenitore (" + volume + ")");
        }
        this.volume = volume;
        this.liquido = liquido;
        this.qty = qty;
    }

//set-get
    public void setVolume(double volume){
        this.volume = volume;
    }

    public void setLiquido(String liquido){
        this.liquido = liquido;
    }

    public void setQty(double qty){
        this.qty = qty;
    }

    public double getVolume(){
        return this.volume;
    }

    public String getLiquido(){
        return this.liquido;
    }

    public double getQty(){
        return this.qty;
    }

//metodi
    public static void versa(Contenitore cVersa, Contenitore cRiceve) throws LiquidsException{
    //EFFECTS: versa il contenuto di cVersa in cRiceve 
    //         se i liquidi dei due contenitori non sono compatibili lancia liquidsexception
    //         Altrimenti, il `Contenitore` sarà riempito fino alla sua massima capienza ed il resto del liquido rimarrà nel `Contenitore` di origine.
    //MODIFIES: cVersa, cRiceve
        if (cVersa.getQty() > 0 && cRiceve.getLiquido() != null && cVersa.getLiquido() != null && !cVersa.getLiquido().equals(cRiceve.getLiquido())) {
            throw new LiquidsException("liquidi incompatibili " + cVersa.getLiquido() + " e " + cRiceve.getLiquido());
        }

        if (cRiceve.getQty() == 0 && cVersa.getQty() > 0) {
            cRiceve.setLiquido(cVersa.getLiquido());
        }

        double spazioDisponibile = cRiceve.volume - cRiceve.qty;
        double daVersare = cVersa.qty;

        if (daVersare > spazioDisponibile) { // Riempie cRiceve e lascia il resto in cVersa
            cVersa.setQty(daVersare - spazioDisponibile);
            cRiceve.setQty(cRiceve.volume);
        } else { // Versa tutto
            cRiceve.setQty(cRiceve.qty + daVersare);
            cVersa.setQty(0);
        }
    }

    @Override
    public int compareTo(Contenitore other) {
        return Double.compare(this.volume, other.volume);
    }

    public boolean repOk(){
        return qty >= 0 && qty <= volume && liquido != null;
    }

    public static void main(String[] args) {
        Contenitore s = new Sfera(2.0, "acqua", 25);
        Contenitore q = new Cuboide(2.0, 3.0, 4.0, null, 0);
        Contenitore c = new Cilindro(3.0, 2.0, "alcool", 20);

        // Travaso Sfera -> Cilindro
        try {
            versa(s, c);
            System.out.println("travaso effettuato con successo!");
        } catch (LiquidsException e) {
            System.out.println(e.getMessage());
        }

        // Travaso Sfera -> Cuboide
        try {
            versa(s, q);
            System.out.println("travaso effettuato con successo!");
        } catch (LiquidsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(s);
        System.out.println(q);
        System.out.println(c);
    }
}
