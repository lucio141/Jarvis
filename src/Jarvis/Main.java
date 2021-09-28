
package Jarvis;

public class Main {

    public static void main(String[] args) {
        Radar r = new Radar();
        
        r.buscarObjetos();
        r.mostrarObjetos();
        System.out.println("Muevo 10 en X");
        r.moverse("X", 10);
        r.mostrarObjetos();
        System.out.println("Muevo -60 en Z");
        r.moverse("Z", -60);
        r.mostrarObjetos();
        System.out.println("Muevo -50 en Y");
        r.moverse("y", -50);
        r.mostrarObjetos();
    }
    
}
