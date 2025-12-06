import java.time.LocalDate;

// La classe Dramma usa la penale di default (2€), quindi non ha bisogno
// di sovrascrivere il metodo getPenaleGiornaliera().
public class Dramma extends Film {
    public Dramma(String codice, String titolo, LocalDate dataNoleggio) {
        super(codice, titolo, dataNoleggio);
    }
}
