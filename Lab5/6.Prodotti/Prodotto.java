public class Prodotto {
//OVERVIEW: modella i prodotti di un negozio con nome, costo

//attributi
    private final String nome;
    private double costo;

//costruttori
    public Prodotto(String nome, double costo){
        if (costo < 0) {
            throw new IllegalArgumentException("Il costo non può essere negativo.");
        }
        this.nome = nome;
        this.costo = costo;
    }

//metodi
    public String getNome(){
        return nome;
    }

    public double getCosto(){
        return costo;
    }

    public void setCosto(double costo) throws IllegalArgumentException {
        if (costo < 0) {
            throw new IllegalArgumentException("Il costo non può essere negativo.");
        }
        this.costo = costo;
    }
    
    public double sconto(){
        return this.costo - (0.05 * this.costo);
    }
}
