package Simulazione.try1;

import java.util.Scanner;
import java.lang.Math;

public class Contenitore implements Volumi{
//OVERVIEW: modella un contenitore che contiene dei liquidi

//attributi
    public String liquido;
    public double qty;
    public double capacity;
                                                        

//costruttore
    public Contenitore(String liquido, double qty, double capacity) {
        this.liquido = liquido;
        this.qty = qty;
        this.capacity = capacity;
    }

//metodi
    //set-get
    public String getLiquido(){
        return this.liquido;
    }

    public double getQty(){
        return this.qty;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public void setLiquido(String liquido){
        this.liquido = liquido;
    }

    public void setQty(double qty){
        this.qty = qty;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    //volumi
    public double volumeSfera(double r){
        double capacity = (4.0/3.0)*(Math.PI *Math.pow(r, 3));
        return capacity;
    }

    public double volumeCuboide(double latoA, double latoB, double latoC){
        double capacity = latoA * latoB * latoC;
        return capacity;
    }

    public double volumeCilindro(double r, double h){
        double capacity = h * Math.PI * Math.pow(r, 2);
        return capacity;
    }

    public static void versa(Contenitore cVersato, Contenitore cContiene) throws CapacityException, LiquidsException{
    //EFFECTS: versa il liquido del cVersato in cContiene 
    //          se i liquidi sono diversi e quindi incompatibili lancia una nuova LiquidsException
    //          se la quantità che si prova a versare eccede la capacità di cContiente lancia una nuova CapacityException
        if(!isCompatibile(cVersato, cContiene)) {
            // This code is unreachable if isCompatibile throws an exception, but kept for clarity.
            throw new LiquidsException("Liquidi incompatibili");
        }
        
        if (cContiene.getCapacity() < cContiene.getQty() + cVersato.getQty()){
            throw new CapacityException("Capacità non sufficiente");
        }
        
        cContiene.qty += cVersato.qty;
        cVersato.qty = 0; // The liquid has been poured out from the source container.
        System.out.println("Versamento completato.");
        System.out.println("Situazione sorgente: " + cVersato);
        System.out.println("Situazione destinazione: " + cContiene);
    }

    public static boolean isCompatibile(Contenitore c1, Contenitore c2) throws LiquidsException{
        // if the destination container is empty, it can receive any liquid
        if (c2.getQty() == 0) {
            c2.setLiquido(c1.getLiquido());
            return true;
        }
        if (c1.liquido == null || !c1.liquido.equals(c2.liquido)){
            throw new LiquidsException("Liquidi incompatibili: " + c1.liquido + " e " + c2.liquido);
        }
        return true;
    }

    @Override
    public String toString(){
        return "Contenitore [liquido=" + liquido + ", qty=" + qty + ", capacity=" + capacity + "]";
    }

    public boolean repOk(){
        if (liquido == null || liquido.isEmpty()) {
            return false;
        }
        if (qty < 0) {
            return false;
        }
        if (capacity < 0) {
            return false;
        }
        if (qty > capacity) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Sfera s = new Sfera(2, "acqua", 1.0, 0);
        Cuboide q = new Cuboide(2.0, 3.0, 4.0, "acqua", 24.0, 0.0);
        Cilindro c = new Cilindro(3.0, 2.0, "alcool", 20.0, 0);

        s.setCapacity(s.volumeSfera(s.raggio));
        q.setCapacity(q.volumeCuboide(q.latoA, q.latoB, q.latoC));
        c.setCapacity(c.volumeCilindro(c.r, c.h));

        System.out.println("Stato iniziale:");
        System.out.println("Sfera: " + s);
        System.out.println("Cuboide: " + q);
        System.out.println("Cilindro: " + c);
        System.out.println("---");

        // Asserts need to be enabled with the -ea flag for the JVM
        assert s.repOk() && q.repOk() && c.repOk();

        System.out.println("Tentativo di versare acqua in alcool (fallirà):");
        try {
            versa(s, c);
        } catch (LiquidsException e) {
            System.out.println("OK: " + e.getMessage());
        } catch (CapacityException e) {
            System.out.println("ERRORE INATTESO: " + e.getMessage());
        }
        System.out.println("---");


        System.out.println("Tentativo di versare acqua in acqua (riuscirà):");
        try {
            versa(s, q);
        } catch (CapacityException | LiquidsException e) {
            System.out.println("ERRORE INATTESO: " + e.getMessage());
        }
        System.out.println("---");

        assert s.repOk() && q.repOk() && c.repOk();
    }
}
