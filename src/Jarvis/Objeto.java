package Jarvis;

import java.util.Comparator;


public class Objeto {

    private int ejeX;
    private int ejeY;
    private int ejeZ;
    
    private int resistencia;
    
    
    private boolean hostil;
    private int ataque;
    
    private boolean animado;
    private int velocidad;

    public Objeto(int ejeX, int ejeY, int ejeZ, int resistencia, boolean hostil, int ataque, boolean animado, int velocidad) {
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.ejeZ = ejeZ;
        this.resistencia = resistencia;
        this.hostil = hostil;
        this.ataque = ataque;
        this.animado = animado;
        this.velocidad = velocidad;
    }

    
    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public int getEjeZ() {
        return ejeZ;
    }

    public void setEjeZ(int ejeZ) {
        this.ejeZ = ejeZ;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

        public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public boolean isAnimado() {
        return animado;
    }

    public void setAnimado(boolean animado) {
        this.animado = animado;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }   
    
    
    //EL calculo de distancia se realiza tomando como base que La armadura siempre será el eje 0,0,0
    //Calculo de distancia 3D http://campusvirtual.cua.uam.mx/pdfs/paea/18o/tm/tema5_cont_c.pdf
    public Integer getDistancia() {
        return (int)(Math.round(Math.sqrt(Math.pow(ejeX,2) + Math.pow(ejeY,2) + Math.pow(ejeZ,2))));
    }
    
        //Comparo la distancia de los objetos para ponerles orden de ataque
    public static Comparator<Objeto> distancias = new Comparator<Objeto>(){
        @Override
        public int compare(Objeto t, Objeto t1) {
            return t.getDistancia().compareTo(t1.getDistancia());
        }
    };

    @Override
    public String toString() {
        String esHostil,esAnimado;
        if(hostil){
            esHostil = "Hostil: Poder = " + ataque;
        }else{
            esHostil = "Neutral";
        }
        
        if(animado){
            esAnimado = "En movimiento a " + velocidad + "m/h";
        }else{
            esAnimado = "Inmovil";
        }
        return esHostil + " resistencia = " +  resistencia + esAnimado + 
                "\n Posición (" + ejeX + "," + ejeY +"," + ejeZ +", Distancia = " + getDistancia();
    }
    
    
}
