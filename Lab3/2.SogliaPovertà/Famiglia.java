import java.util.InputMismatchException;
import java.util.Scanner;

public class Famiglia {
//OVERVIEW: modella una famiglia attraverso i costi che affronta, in particolare costo medio di vitto e alloggio, il loro reddito e dimensione e definisce se la famiglia è al di sotto la soglia di povertà

//attributi
public int reddito;
public int dimensioneFamiglia;

//costruttore
public Famiglia(double reddito, int dimensioneFamiglia) throws InputMismatchException{
    this.reddito = reddito;
    this.dimensioneFamiglia = dimensioneFamiglia;
}

//metodi
public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException{
    
}

public String toString(){
    soglia
}

public static void main(String args[]){
    Famiglia family; 
    
    if (args.length>0){
        family.costoVitto = args[1];
        family.costoAlloggio = args[2];
    } else {
        System.out.println("Inserire costo del vitto e costo dell'alloggio.");
        break;
    }

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {
        System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");

    }
}

}
