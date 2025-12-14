package soluzioneMia;

import java.util.ArrayList;

public class Prodotto {
//OVERVIEW: la classe modella un prodotto definito da nome e prezzo

//attributi
    protected String nome;
    protected double prezzo;

//costruttore
    public Prodotto(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

//metodi

//set-get
    public void setPrezzo(double prezzo){
        this.prezzo = prezzo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPrezzo(){
        return this.prezzo;
    }

    public String getNome(){
        return this.nome;
    }

    public String modPrice(Prodotto p, double prezzoNuovo) throws NullPointerException, IllegalArgumentException {
        if (p == null) {
            throw new NullPointerException("Prodotto nullo");
        } else if (!(prezzoNuovo instanceof double)) {
            throw new IllegalArgumentException("Inserisci un prezzo in double");
        } else {
            p.setPrezzo(prezzoNuovo);
            return "Prezzo cambiato correttamente";
        }
    }

    public ArrayList<Prodotto> ordinaProdotti(ArrayList<Prodotto> prodotti){
        for (Prodotto p : prodotti) {
            
        }
    }

    //inserisci main che crea l'arraylist ogni volta che un prodotto viene inserito

}
