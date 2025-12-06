import java.time.LocalDate;

public class Film {
//OVERVIEW: modella un film noleggiabile e ne calcola la penale.

//attributi
    public String titolo;
    public LocalDate dataNoleggio;
    public String genere;

//costruttori
    public Film(String titolo, String genere, LocalDate dataNoleggio) {
        this.titolo = titolo;
        this.dataNoleggio = dataNoleggio;
        this.genere = genere;
    }

//metodi
    public static double calcolaPenaleRitardo(LocalDate dataNoleggio, String genere) {
        int mult = LocalDate.now() - LocalDate.plusDays(7)
    }
}