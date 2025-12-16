public class Piatto {
    // attributi
    private final String nome;
    private final String tipo;
    private double costo;

    // costruttore
    public Piatto(String nome, String tipo, double costo){
        this.nome = nome;
        this.tipo = tipo;
        this.costo = costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNome(){ 
        return this.nome; 
    }

    public String getTipo(){ 
        return this.tipo; 
    }
    
    public double getCosto(){ 
        return this.costo; 
    }

    public String toString(){
        return ("Nome: " + this.nome + "\n Tipo: " + this.tipo + "\n Costo: " + this.costo + "€");
    }
}