package Simulazione.try1;

public class LiquidsException extends Exception {
    public LiquidsException() {
        super();
    }

    public LiquidsException(String message) {
        super("I liquidi non sono compatibili");
    }
}
