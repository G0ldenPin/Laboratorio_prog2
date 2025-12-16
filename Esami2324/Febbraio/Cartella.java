import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Cartella extends Contenuto{
//OVERVIEW: modella una cartella che contiene contenuti e che tiene traccia di eventuali supercartelle

//attributi
    private ArrayList<Contenuto> currentDirArray;

//costruttori
    public Cartella(String nome, int dimensione, String superdir, ArrayList<Contenuto> currentDirArray) throws NullPointerException, IllegalArgumentException{
        super(nome, dimensione, superdir);
        if (currentDirArray == null) {
            this.currentDirArray = new ArrayList<>();
        } else {
            this.currentDirArray = currentDirArray;
        }
    }

//metodi
    @Override
    public int getDimensione(){
    //EFFECTS: ritorna la dimensione complessiva del contenuto di una cartella, cioè la somma della dimensione dei contenuti in una cartella (ricorsivamente per le sottocartelle)
    //          se la cartella è vuota ritorna dimensione = 0
    int totaleDimensione = 0;
        for (Contenuto contenuto : currentDirArray) {
            totaleDimensione += contenuto.getDimensione();
        }   
        return totaleDimensione;
    }

    public Contenuto getCartella(String nome) throws NoSuchElementException, NoSuchDirException {
    //EFFECTS: ritorna la cartella c1 contenuta all'interno di una cartella c2 dato il suo nome
    //          se il nome non sia appartenente all'insieme di contenuti della cartella c2 lancia NoSuchElementException
    //          se il nome corrisponde invece a quello di un documento contenuto, lancia una NoSuchDirException
    //MODIFIES: c
        for (Contenuto contenuto : currentDirArray) {
            if (this.getNome() == contenuto.getNome()){
                if (contenuto instanceof Cartella){
                    contenuto.setSuperdir(this.getNome());
                    return contenuto;
                } else {
                    throw new NoSuchDirException("Non esiste una cartella con questo nome nella cartella corrente.");
                }
            } else {
                throw new NoSuchElementException("Nessun elemento trovato col nome inserito.");
            }
        }

        return null;
    }

    public void addContenuto(Contenuto c) throws ElementExistsException{
    //EFFECTS: aggiunge un contenuto alla cartella. se il contenuto è una cartella allora this viene messo come supercartella
    //          se il contenuto esiste già lancia elementexistsexception
    //MODIFIES: currentDirArray
        for (Contenuto contenuto : currentDirArray) {
            if (contenuto.getNome().equals(c.getNome())) {
                throw new ElementExistsException("Contenuto con nome '" + c.getNome() + "' già esistente nella cartella attuale.");
            }
        }
        
        currentDirArray.add(c);
    }

    public void removeContenuto(Contenuto c) throws NoSuchElementException {
    //EFFECTS: rimuove un contenuto sulla base del nome
    //MODIFIES: currentDirArray
        if (!currentDirArray.contains(c)){
            throw new NoSuchElementException("PIPPOLI PIPPOLA");
        }
        currentDirArray.remove(c);

    }

    /*public static void main(String[] args){
        Contenuto contenuto = new Contenuto("lavoro", 10, null);
        Cartella cartella = new Cartella("casa", 0, null, null);
        Documento documento = new Documento("famiglia", 20, null);
        Cartella cartella2 = new Cartella("casa", 0, null, null);

        System.out.println(contenuto);
        System.out.println(cartella);
        System.out.println(documento);

        try {
            cartella.addContenuto(documento);
            cartella.addContenuto(cartella2);
            cartella.addContenuto(contenuto);
            System.out.println(cartella.currentDirArray);
        } catch (ElementExistsException e){
            System.out.println("leccami il prepuzio");
        }

        try{
            cartella.removeContenuto(documento);
            System.out.println(cartella.currentDirArray);
        } catch (NoSuchElementException e) {
            System.out.println("PEFFFFFFOOOOOOOOOO");
        }

        try{
            System.out.println(cartella.getCartella("cartella2"));
        } catch (NoSuchDirException e){
            System.out.println("suca");
        }

        System.out.println(cartella.getDimensione());
    }*/
}