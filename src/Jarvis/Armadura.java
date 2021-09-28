
package Jarvis;

//En este trabajo se deberá crear en el proyecto una clase llamada Armadura que modele

import java.util.ArrayList;
import java.util.List;



//toda la información y las acciones que pueden efectuarse con la Armadura de Iron Man.
//La armadura de Iron Man es un exoesqueleto mecánico ficticio usado por Tony Stark
//cuando asume la identidad de Iron Man. La primera armadura fue creada por Stark y Ho
//Yinsen, mientras estuvieron prisioneros.



public class Armadura {
//Las armaduras de Stark se encuentran definidas por un color primario y un color
//secundario. Se encuentran compuestas de dos propulsored, uno en cada bota; y dos
//repulsores, uno en cada guante (los repulsores se utilizan también como armas). Tony los
//utiliza en su conjunto para volar.
    
//La armadura tiene un nivel de resistencia, que depende del material con el que está
//fabricada, y se mide con un número entero cuya unidad de medida de dureza es
//Rockwell (https://es.wikipedia.org/wiki/Dureza_Rockwell). Todas las armaduras poseen
//un nivel de salud el cual se mide de 0 a 100. Además, Tony tiene un generador, el cual le
//sirve para salvarle la vida en cada instante de tiempo alejando las metrallas de metal de
//su corazón y también para alimentar de energía a la armadura. La batería a pesar de estar
//en el pecho de Tony, es considerada como parte de la armadura.
//La armadura también posee una consola en el casco, a través de la cual JARVIS le
//escribe información a Iron Man. En el casco también se encuentra un sintetizador por
//donde JARVIS susurra cosas al oído de Tony. Cada dispositivo de la armadura de Iron
//Man (botas, guantes, consola y sintetizador) tienen un consumo de energía asociado.
    
    private String colorPrimario;
    private String colorSecundario;
    private Dispositivo botaIzquierda;
    private Dispositivo botaDerecha;
    private Dispositivo guanteIzquierdo;
    private Dispositivo guanteDerecho;
    private int resistencia;
    private int nivelDeSalud;
    private Dispositivo sintetizador;
    private Dispositivo consola;
    private static final float CARGA_MAXIMA_BATERIA = Float.MAX_VALUE; 
    private float bateria;
    

    public Armadura(String colorPrimario, String colorSecundario, Dispositivo botaIzquierda, Dispositivo botaDerecha, Dispositivo guanteIzquierdo, Dispositivo guanteDerecho, int resistencia, Dispositivo sintetizador, Dispositivo consola) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.botaIzquierda = botaIzquierda;
        this.botaDerecha = botaDerecha;
        this.guanteIzquierdo = guanteIzquierdo;
        this.guanteDerecho = guanteDerecho;
        this.resistencia = resistencia;
        this.sintetizador = sintetizador;
        this.consola = consola;
        this.nivelDeSalud = 100;
        this.bateria=CARGA_MAXIMA_BATERIA;
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Dispositivo getBotaIzquierda() {
        return botaIzquierda;
    }

    public void setBotaIzquierda(Dispositivo botaIzquierda) {
        this.botaIzquierda = botaIzquierda;
    }

    public Dispositivo getBotaDerecha() {
        return botaDerecha;
    }

    public void setBotaDerecha(Dispositivo botaDerecha) {
        this.botaDerecha = botaDerecha;
    }

    public Dispositivo getGuanteIzquierdo() {
        return guanteIzquierdo;
    }

    public void setGuanteIzquierdo(Dispositivo guanteIzquierdo) {
        this.guanteIzquierdo = guanteIzquierdo;
    }

    public Dispositivo getGuanteDerecho() {
        return guanteDerecho;
    }

    public void setGuanteDerecho(Dispositivo guanteDerecho) {
        this.guanteDerecho = guanteDerecho;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getNivelDeSalud() {
        return nivelDeSalud;
    }

    public void setNivelDeSalud(int nivelDeSalud) {
        this.nivelDeSalud = nivelDeSalud;
    }

    public Dispositivo getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Dispositivo sintetizador) {
        this.sintetizador = sintetizador;
    }

    public Dispositivo getConsola() {
        return consola;
    }

    public void setConsola(Dispositivo consola) {
        this.consola = consola;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }
    
    
    
    
    
//• Al caminar la armadura hará un uso básico de las botas y se consumirá la energía
//establecida como consumo en la bota por el tiempo en el que se camine.
    
    public void caminar(int minutos) throws BateriaExcepcion{
        try {
            float consumo = botaDerecha.usar(minutos, 1) + botaIzquierda.usar(minutos, 1);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
    }
    
//• Al correr la armadura hará un uso normal de las botas y se consumirá el doble de la
//energía establecida como consumo en la bota por el tiempo en el que se corra.

        public void correr(int minutos) throws BateriaExcepcion{
        try {
            float consumo = botaDerecha.usar(minutos, 2) + botaIzquierda.usar(minutos, 2);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
    }



//• Al propulsarse la armadura hará un uso intensivo de las botas utilizando el triple de la
//energía por el tiempo que dure la propulsión.

    public void propulsar(int minutos) throws BateriaExcepcion{
        try {
            float consumo = botaDerecha.usar(minutos, 3) + botaIzquierda.usar(minutos, 3);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
    }

//• Al volar la armadura hará un uso intensivo de las botas y de los guantes un uso normal
//consumiendo el triple de la energía establecida para las botas y el doble para los
//guantes.
    
    public void volar(int minutos) throws BateriaExcepcion{
        try {
            float consumo = botaDerecha.usar(minutos, 3) + botaIzquierda.usar(minutos, 3) + guanteDerecho.usar(minutos,1) + guanteIzquierdo.usar(minutos,1);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
    }
    
    
//• Al utilizar los guantes como armas el consumo se triplica durante el tiempo del
//disparo.
    public int disparar(int minutos) throws BateriaExcepcion{
        int disparos= 0;
        try {
            float consumo = guanteDerecho.usar(minutos,3);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
                disparos++;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
         try {
            float consumo = guanteIzquierdo.usar(minutos,3);
            if(consumo > bateria){
                throw new BateriaExcepcion("La armadura no posee batería suficiente para realizar la acción");
            }else {
                bateria-=consumo;
                disparos++;
            }
        } catch (DanioExcepcion e) {
            escribir(e.getMessage());
        }
         return disparos;   
    }
    
//• Cada vez que se escribe en la consola o se habla a través del sintetizador se consume
//lo establecido en estos dispositivos. Solo se usa en nivel básico.
    
    public void leer() throws BateriaExcepcion{
        try {
            if(bateria==1){
                throw new BateriaExcepcion("La armadura no posee bateria suficiente para realizar la acción");
            }
            sintetizador.usar(1,1);
        } catch (DanioExcepcion ex) {
            escribir(ex.getMessage());
        }
    }
    
    public void escribir(String msg){
        if(bateria<=0){
            System.out.println("FATAL ERROR BATERIA");
        }
        System.out.println(msg);
    }

    
    public float estadoDeBateria(){
        return (bateria*100/CARGA_MAXIMA_BATERIA);
    }
    
    
    public List<Dispositivo> getDispositivos(){
        List<Dispositivo> dispositivos = new ArrayList();
        dispositivos.add(consola);
        dispositivos.add(sintetizador);
        dispositivos.add(botaDerecha);
        dispositivos.add(botaIzquierda);
        dispositivos.add(guanteDerecho);
        dispositivos.add(guanteIzquierdo);
        return dispositivos;
    }
    
    @Override
    public String toString() {
        return "Armadura: colorPrimario=" + colorPrimario + " colorSecundario:" + colorSecundario + "\n"
                + "resistencia:" + resistencia + "HR nivelDeSalud:" +  nivelDeSalud + " bateria:" + (bateria*100/CARGA_MAXIMA_BATERIA) + "%" 
                + botaIzquierda +"\n" + botaDerecha + "\n" + guanteIzquierdo + "\n" + guanteDerecho + "\n" + sintetizador + "\n" + consola;
    }
    
    
}
