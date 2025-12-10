import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un prodotto nel formato: `<nome> <costo> alimentare <datascadenza>` oppure `<nome> <costo> nondeperibile riciclabile\\nonriciclabile`");

        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(" ");
            
            try {
                String nome = parts[0];
                double costo = Double.parseDouble(parts[1]);
                String tipo = parts[2];

                Prodotto prodotto = null;

                if (tipo.equals("alimentare")) {
                    if (parts.length != 4) {
                        System.out.println("Formato non valido per prodotto alimentare.");
                        continue;
                    }
                    LocalDate dataScadenza = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    prodotto = new ProdottoAlimentare(nome, costo, dataScadenza);
                } else if (tipo.equals("nondeperibile")) {
                    if (parts.length != 4) {
                        System.out.println("Formato non valido per prodotto non deperibile.");
                        continue;
                    }
                    boolean riciclabile = parts[3].equals("riciclabile");
                    prodotto = new ProdottoNonDeperibile(nome, costo, riciclabile);
                } else {
                    System.out.println("Tipo di prodotto non valido: " + tipo);
                    continue;
                }

                double prezzoScontato = prodotto.sconto();
                double scontoPercentuale = (1 - (prezzoScontato / prodotto.getCosto())) * 100;

                String output;
                if (Math.abs(scontoPercentuale - 30) < 0.1) {
                    output = String.format("Prezzo con sconto del 30%%: %.2f", prezzoScontato);
                } else if (Math.abs(scontoPercentuale - 10) < 0.1) {
                    output = String.format("Prezzo con sconto del 10%%: %.2f", prezzoScontato);
                } else {
                    output = String.format("Prezzo con sconto del 5%%: %.2f", prezzoScontato);
                }
                System.out.println(output);

            } catch (NumberFormatException e) {
                System.out.println("Errore: costo non valido.");
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Errore: formato data non valido. Usare dd-MM-yyyy.");
            } catch (ArrayIndexOutOfBoundsException | NoSuchElementException e) {
                System.out.println("Errore: input incompleto o in formato non corretto.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        s.close();
    }
}
