public class ProdottoNonDeperibile extends Prodotto {
    private final boolean riciclabile;

    public ProdottoNonDeperibile(String nome, double costo, boolean riciclabile){
        super(nome, costo);
        this.riciclabile = riciclabile;
    }

    public boolean isRiciclabile() {
        return riciclabile;
    }

    @Override
    public double sconto(){
        if (riciclabile){
            return getCosto() - (0.10 * getCosto());
        }
        return super.sconto();
    }
}
