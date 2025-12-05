import java.util.InputMismatchException;
import java.util.Scanner;

public class Svolgicalcolo{
//OVERVIEW: modella una calcolatrice sequenziale su numeri decimali che conserva lo stato di memoria e applica al risultato in memoria le operazioni .

//attributi
private double mem;

//costruttori
    public Svolgicalcolo() {
    //MODIFIES: this
    //EFFECTS: inizializza la calcolatrice a 0
        this.mem = 0;
    }

    public Svolgicalcolo(double mem){
    //MODIFIES: this
    //EFFECTS: inizializza la calcolatrice a 0
        this.mem = mem;
    }

//metodi
    public double getMem(){
    //EFFECTS: restituisce il valore corrente in memoria
        return this.mem;
    }

    public double add(double op2){
    //MODIFIES: this
    //EFFECTS: somma il valore in memoria e op2, resituendo come mem il risultato
        this.mem+=op2;
        return this.mem;
    }

    public double sub(double op2){
    //MODIFIES: this
    //EFFECTS: sottrae il valore in memoria e op2, resituendo come mem il risultato        
        this.mem-=op2;
        return this.mem;
    }

    public double mul(double op2){
    //MODIFIES: this
    //EFFECTS: mmoltiplica il valore in memoria e op2, resituendo come mem il risultato        
        this.mem*=op2;
        return this.mem;
    }

    public double div(double op2) throws DivideByZeroException{
    //MODIFIES: this
    //EFFECTS: divide il valore in memoria e op2, resituendo come mem il risultato        
    //          se op2=0 lancia l'eccezione DivideByZeroException
        if (op2==0){
            throw new DivideByZeroException("Non è possibile dividere per zero!!");
        }

        this.mem/=op2;
        return this.mem;
    }

    public double operate(char operator, double op2) throws DivideByZeroException, InputMismatchException {
    //MODIFIES: this
    //EFFECTS: svolge l'operazione definita da char tra mem e op2
    //          se l'operatore non è tra i caratteri definiti (+,-,*,/) allora lancia InputmismatchException
    //          se op2=0 lancia DivideByZeroException
        switch (operator) {
            case '+':
                this.add(op2);
                return this.mem;
            case '-':
                this.sub(op2);
                return this.mem;
            case '*':
                this.mul(op2);
                return this.mem;
            case '/':
                this.div(op2); //qui può lanciare dividebyzeroexception
                return this.mem;
            default:
                throw new InputMismatchException("Operatore non riconosciuto");
        }

    }

    public static void printHead(){
        //MODIFIES: System.out
	//EFFECTS: stampa l'intestazione delle operazioni
		System.out.println("Inserisci <operatore> <operando>. es: + 3");
		System.out.println("Per terminare inserire il carattere '='");
    }

    public static void main(String args[]){
        Svolgicalcolo calc;

        if (args.length>0){
            calc = new Svolgicalcolo(Integer.parseInt(args[0]));
        } else {
            calc = new Svolgicalcolo();
        }
        System.out.println("Calcolatrice inizializzata, valore: " + calc.getMem());
		printHead();

        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            char operator = s.next().charAt(0);

            if (operator == '='){
                break;
            }

            double op2 = s.nextDouble();

            try {
                calc.operate(operator, op2);
            } catch (DivideByZeroException e){
                System.out.println(e.getMessage());
				printHead();
            }
            System.out.println("Valore in memoria: " + calc.getMem());
        }

        s.close();
        System.out.println("Il risultato finale è " + calc.getMem());
    }

}