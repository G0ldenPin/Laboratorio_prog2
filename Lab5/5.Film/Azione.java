import java.time.LocalDate;

public class Azione extends Film {
    public Azione(String codice, String titolo, LocalDate dataNoleggio) {
        super(codice, titolo, dataNoleggio);
    }

    @Override
    public double getPenaleGiornaliera() {
        return 3.0; // Penale per film d'azione: 3€
    }
}
