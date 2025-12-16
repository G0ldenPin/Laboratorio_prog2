import java.util.Scanner;

public class Test {

    public static void main(){
        Scanner s = new Scanner(System.in);
        Cartella root = new Cartella("root", 0, null, null);
    
        while (s.hasNext()){
            String comando = s.next();
            String tipo = s.next();
            String nome = s.next();
            int dimensione = s.nextInt();
    
            switch (comando) {
                case "crea":
                    if (tipo == "cartella"){
                        Cartella c = new Cartella(nome, 0, null, null);
                    } else {
                        Documento d = new Documento(nome, dimensione, null);
                    }
    
                case "rimuovi":
    
                case "entra":
                
                case "elenca":
                
                default:
                    break;
            }
        }
    }
}

