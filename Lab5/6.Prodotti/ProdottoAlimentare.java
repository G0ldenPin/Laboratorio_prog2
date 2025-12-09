import java.time.LocalDate;
import java.util.Objects;

public class ProdottoAlimentare extends Prodotto {
    private final LocalDate dataScadenza;

    public ProdottoAlimentare(String nome, double costo, LocalDate dataScadenza){
        super(nome, costo);
        this.dataScadenza = Objects.requireNonNull(dataScadenza, "La data di scadenza non può essere null.");
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public double sconto(){
        if (LocalDate.now().isAfter(this.dataScadenza.minusDays(10))){
            return getCosto() - (0.30 * getCosto());
        }
        return super.sconto();
    }
}
