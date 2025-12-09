import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un prodotto nel formato: `<nome> <costo> alimentare <datascadenza>` oppure `<nome> <costo> nondeperibile riciclabile/nonriciclabile`");

        while (s.hasNext()) {
            try {
                String nome = s.next();
                double costo = s.nextDouble();
                String tipo = s.next();
                String riciclabile = s.next();

                if (tipo.equals("alimentare")) {
                    LocalDate dataScadenza = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd-mm-yyyy"));
                    ProdottoAlimentare pa = new ProdottoAlimentare(nome, costo, dataScadenza);
                    System.out.println("Prezzo con sconto del 30%: " + pa.sconto());
                } else if (tipo.equals("nondeperibile")) {
                    if (riciclabile.equals("riciclabile")) {
                        ProdottoNonDeperibile pnd = new ProdottoNonDeperibile(nome, costo, true);
                        System.out.println("Prezzo con sconto del 10%: " + pnd.sconto());
                    } else {
                        Prodotto p = new Prodotto(nome, costo);
                        System.out.println("Prezzo con sconto del 5%: " + p.sconto());
                    }
                } else {
                    System.out.println("Tipo di prodotto non valido.");
                    continue;
                }

                
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: uno o più valori non sono validi");
            }
        }


    }
}
