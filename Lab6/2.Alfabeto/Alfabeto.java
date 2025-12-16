import java.util.Iterator;
import java.util.NoSuchElementException;

public class Alfabeto implements Iterator<Char>{
//OVERVIEW: la classe implementa un iteratore che permette di generare le lettere dell'alfabeto a partire da un intervallo dato

//attributi 
    private Char inizio;
    private Char fine;

//costruttore
    public Alfabeto(Char inizio, Char fine){
        this.inizio = inizio;
        this.fine = fine;
    }
//metodi
    @Override
    public boolean hasNext(Char[] alfabeto, int i) {
        for (int j = i; j<alfabeto.length; j++){
            if (alfabeto[j] > alfabeto.length) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public Char next(Char[] alfabeto, Char inizio, Char fine) throws NoSuchElementException {
        for (int i = 0; i < alfabeto.length; i++){
            if(!this.hasNext(alfabeto, i)) {
                throw new NoSuchElementException();
            } else {
                if ()
            }
        }
    }

    public static void main(String[] args){
        Char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }
}
