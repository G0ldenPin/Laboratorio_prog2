import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    // OVERVIEW: Classe che contiene una lista di piatti e permette operazioni su di essi.

    private ArrayList<Piatto> listaPiatti;

    public Menu() {
        this.listaPiatti = new ArrayList<>();
    }

    // --- 1. Aggiungere ---
    public void add(Piatto p) {
        listaPiatti.add(p);
    }

    // --- 2. Togliere ---
    public void remove(String nomePiatto) {
        Iterator<Piatto> it = listaPiatti.iterator();
        while (it.hasNext()) {
            if (it.next().getNome().equals(nomePiatto)) {
                it.remove();
                return;
            }
        }
    }

    // --- 3. Modificare (Richiesto dalla consegna) ---
    public void modificaPiatto(String nomePiatto, double nuovoCosto) {
        for (Piatto p : listaPiatti) {
            if (p.getNome().equals(nomePiatto)) {
                p.setCosto(nuovoCosto);
                return;
            }
        }
        throw new NoSuchElementException("Piatto non trovato per la modifica");
    }

    // --- 4. Iteratore Standard (tutti i piatti) ---
    public Iterator<Piatto> getIterator() {
        return listaPiatti.iterator();
    }

    // --- 5. Iteratore Filtrato per Tipo (Richiesto dalla consegna) ---
    // "Se il metodo viene chiamato con un parametro tipo, l'iteratore dovrà generare solamente i piatti di quel tipo"
    public Iterator<Piatto> getIterator(String tipo) {
        ArrayList<Piatto> filtrati = new ArrayList<>();
        for (Piatto p : listaPiatti) {
            if (p.getTipo().equals(tipo)) {
                filtrati.add(p);
            }
        }
        return filtrati.iterator();
    }

    // --- MAIN ---
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner s = new Scanner(System.in);

        System.out.println("aggiungi i piatti nel formato: nome tipo costo (terminare la lettura con CTRL+D):");

        // Lettura fino a EOF (CTRL+D su Linux/Mac, CTRL+Z su Windows)
        while (s.hasNext()) {
            String nome = s.next();
            String tipo = s.next();
            String costoStr = s.next(); // Leggiamo come stringa per gestire il simbolo '€'

            // Parsing del costo: rimuoviamo '€' se presente e convertiamo in double
            double costo;
            try {
                costoStr = costoStr.replace("€", "").replace(",", ".");
                costo = Double.parseDouble(costoStr);
                
                menu.add(new Piatto(nome, tipo, costo));
            } catch (NumberFormatException e) {
                System.err.println("Formato costo non valido per: " + nome);
            }
        }

        // Stampa PRIMI usando l'iteratore filtrato
        System.out.println("\nprimi:");
        Iterator<Piatto> itPrimi = menu.getIterator("primo");
        while (itPrimi.hasNext()) {
            System.out.println(itPrimi.next());
        }

        // Stampa SECONDI usando l'iteratore filtrato
        System.out.println("\nsecondi:");
        Iterator<Piatto> itSecondi = menu.getIterator("secondo");
        while (itSecondi.hasNext()) {
            System.out.println(itSecondi.next());
        }
    }
}