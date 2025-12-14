import java.util.ArrayList;

public class Vetreria implements Iterable<Vetreria> {
//OVERVIEW: la classe modella una collezione di contenitori e permette di aggiungere un contenitore o rimuovere dei contenitori sulla base del liquido presente in essi

//init lista
ArrayList<Contenitore> vetreria = new ArrayList<Contenitore>();

//metodi
public void addToVetreria(ArrayList<Contenitore> vetreria, Contenitore c) throws NullPointerException {
    if (c==null){
        throw new NullPointerException("Il contenitore è nullo");
    } else {
        vetreria.add(c);
    }
}

public ArrayList<Contenitore> removeByLiquid(ArrayList<Contenitore> vetreria, String liquido){
    for (Contenitore c : vetreria) {
        if(c.liquido == liquido){
            vetreria.remove(c);
        }
    }
    return vetreria;
}

public 

}
