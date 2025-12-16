import java.util.NoSuchElementException;

public class Contenuto {
//OVERVIEW: la classe modella un contenuto generico con un nome

//attributi
    private String nome;
    private final int dimensione;
    private String superdir = null;
    

//costruttore
    public Contenuto(String nome, int dimensione, String superdir) throws NullPointerException, IllegalArgumentException{
        if (nome==null){
            throw new NullPointerException("nome nullo");
        } if (nome==""){
            throw new IllegalArgumentException("nome vuoto");
        }
        this.nome = nome;
        this.dimensione = dimensione;
        
    }

//metodi
    //set-get
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getDimensione(){
        return this.dimensione;
    }

    public void setSuperdir(String superdir){
        this.superdir = superdir;
    }

    public String getSuperdir() throws NoSuchElementException {
    //EFFECTS: ritorna la propria supercartella
    //          se la supercartella non esiste lancia nosuchelement exception
        if (this.superdir == null) {
            throw new NoSuchElementException("Non esiste una supercartella per questa cartella");
        } else {
            return this.superdir;
        }
    }

    /*public boolean equals(Contenuto c1, Contenuto c2){
        if (c1.nome == c2.nome){
            return true;
        } else {
            return false;
        }
    }*/
}
