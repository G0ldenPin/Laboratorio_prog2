import java.time.LocalDate;

public class Commedia extends Film {
    public Commedia(String codice, String titolo, LocalDate dataNoleggio) {
        super(codice, titolo, dataNoleggio);
    }

    @Override
    public double getPenaleGiornaliera() {
        return 2.50; // Penale per commedie: 2.50€
    }
}
