import java.util.Iterator;
import java.util.NoSuchElementException; // CORREZIONE ERRORE 3

public class Fibonacci implements Iterator<Integer> {

    // Stato interno (NON usare ArrayList, bastano due int)
    private int corrente = 0;
    private int successivo = 1;

    // Costruttore vuoto (chiamato dal main)
    public Fibonacci() {
        // Inizializza la sequenza a 0, 1
        this.corrente = 0;
        this.successivo = 1;
    }

    @Override
    public boolean hasNext() {
        return true; // La sequenza è infinita
    }

    @Override
    // CORREZIONE ERRORE 1: next() NON deve avere parametri!
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        // Salvo il valore attuale da restituire
        int risultato = corrente;
        
        // Calcolo il prossimo passo
        int somma = corrente + successivo;
        corrente = successivo;
        successivo = somma;
        
        return risultato;
    }

    // Main incluso nella stessa classe per semplicità
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Fibonacci <n>");
            return;
        }

        try {
            // CORREZIONE ERRORE 2: Si scrive Integer.parseInt
            int n = Integer.parseInt(args[0]);

            // CORREZIONE ERRORE 4: Il costruttore ora non vuole argomenti
            Fibonacci f = new Fibonacci();

            System.out.println("Primi " + n + " numeri:");
            for (int i = 0; i < n; i++) {
                System.out.print(f.next() + " ");
            }
            System.out.println();

        } catch (NumberFormatException e) {
            System.out.println("Devi inserire un numero intero valido.");
        }
    }
}