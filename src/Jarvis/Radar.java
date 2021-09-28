package Jarvis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Radar {

    private List<Objeto> objetos;

    public Radar() {
        objetos = new ArrayList();
        buscarObjetos();
    }

    //Se carga la lista de objetos identificados por el radar
    public void buscarObjetos() {
        do {
            objetos.add(crearObjeto());
        } while (objetos.size() < 10);
        ordenarObjetos();
    }

    //Se crean objetos al alcance del radar
    public Objeto crearObjeto() {
        int x, y, z;
        int resistencia = (int) (Math.floor(Math.random() * 500) + 500);
        int ataque = (int) (Math.floor(Math.random() * 10));
        int velocidad = (int) (Math.floor(Math.random() * 10));
        boolean hostil = true;
        boolean animado = true;

        //La distancia de los objetos debe ser de un maximo de 500 metros
        //Tanto el eje y como el z pueden ser negativos
        do {
            x = (int) (Math.floor(Math.random() * 500));
            if (Math.floor(Math.random() * 2) == 0) {
                x *= -1;
            }
            
            y = (int) (Math.floor(Math.random() * 500));
            
            z = (int) (Math.floor(Math.random() * 500));
            if (Math.floor(Math.random() * 2) == 0) {
                z *= -1;
            }
        } while (calcularDistancia(x, y, z) > 500);

        //Si no es hostil pierde potencia de ataque
        if (Math.floor(Math.random() * 2) == 0) {
            hostil = false;
            ataque = 0;
        }

        //Si no es animado pierde capacidad de movimiento
        if (Math.floor(Math.random() * 2) == 0) {
            animado = false;
            velocidad = 0;
        }

        return new Objeto(x, y, z, resistencia, hostil, ataque, animado, velocidad);

    }

    //EL calculo de distancia se realiza tomando como base que La armadura siempre será el eje 0,0,0
    //Calculo de distancia 3D http://campusvirtual.cua.uam.mx/pdfs/paea/18o/tm/tema5_cont_c.pdf
    public Integer calcularDistancia(int ejeX, int ejeY, int ejeZ) {
        return (int) (Math.round(Math.sqrt(Math.pow(ejeX, 2) + Math.pow(ejeY, 2) + Math.pow(ejeZ, 2))));
    }

    //Se ordena a los objetos del mas cercano al mas lejano para la prioridad de acción
    public void ordenarObjetos() {
        objetos.sort(Objeto.distancias);
    }

    //Se descartan los objetos lejanos
    public void perderDeVista() {
        Iterator<Objeto> iterador = objetos.iterator();
        while (iterador.hasNext()) {
            if (iterador.next().getDistancia() > 500) {
                iterador.remove();
            }
        }
    }

    //Se gestiona el movimiento y se reposiciona los objetos
    public void moverse(String eje, int metros) {
        switch (eje.toLowerCase()) {
            case "x":
                for (Objeto objeto : objetos) {
                    objeto.setEjeX(objeto.getEjeX() - metros);
                }
                break;
            case "y":
                for (Objeto objeto : objetos) {
                    if(objeto.getEjeY()<= metros){
                        objeto.setEjeY(0);
                    }else{
                        objeto.setEjeY(objeto.getEjeY() - metros);
                    }
                }
                break;
            case "z":
                for (Objeto objeto : objetos) {
                    objeto.setEjeZ(objeto.getEjeZ() - metros);
                }
                break;
            default:
                throw new AssertionError();
        }
        
        ordenarObjetos();
        perderDeVista();
    }
    
    //Se muestran los objetos en el radar
    public void mostrarObjetos(){
        int i = 0;
        for (Objeto objeto : objetos) {
            i++;
            System.out.println("Objeto " + i + ": " + objeto);
            System.out.println("*****************************");
        }
    }
}

