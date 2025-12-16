package Simulazione.try1;

public class CapacityException extends Exception{
    public CapacityException(){
        super();
    }

    public CapacityException(String message){
        super("Il liquido che stai versando è troppo per la capacità del contenitore ricevente");
    }
}
