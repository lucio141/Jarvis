package Jarvis;

//Cada dispositivo de la armadura de Iron
//Man (botas, guantes, consola y sintetizador) tienen un consumo de energía asociado.

public class Dispositivo {
    private float consumoDeEnergia;
    private boolean daniado;
    private boolean destruido;
    private String referencia;
    

    public Dispositivo(float consumoDeEnergia, String referencia) {
        this.consumoDeEnergia = consumoDeEnergia;
        this.referencia = referencia;
        destruido=false;
        daniado=false;
        
    }

    public Dispositivo() {
    }

    public float getConsumoDeEnergia() {
        return consumoDeEnergia;
    }

    public void setConsumoDeEnergia(float consumoDeEnergia) {
        this.consumoDeEnergia = consumoDeEnergia;
    }

    public boolean isDaniado() {
        return daniado;
    }

    public void setDaniado(boolean daniado) {
        this.daniado = daniado;
    }

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    
//Cada vez que se efectúa una acción se llama a los métodos usar del dispositivo se le
//pasa el nivel de intensidad y el tiempo. El dispositivo debe retornar la energía
//consumida y la armadura deberá informar al generador se ha consumido esa
//cantidad de energía.
        
    public float usar(int minutos, int intensidad) throws DanioExcepcion{
        sufriendoDanio();
        if(daniado == true){
            throw new DanioExcepcion("El dispositivo " + referencia + " esta dañado y no puede utilizarse");
        }
        return consumoDeEnergia*minutos*intensidad;
    }
    
//A veces los dispositivos de la armadura sufren daños para esto cada dispositivo contiene
//un atributo público que dice si el dispositivo se encuentra dañado o no. Al utilizar un
//dispositivo existe un 30% de posibilidades de que se dañe.    
    public void sufriendoDanio(){

        int probabilidadDeDanio = (int)(Math.floor(Math.random()*10));
        if(probabilidadDeDanio<=3)daniado=true;
    }

    @Override
    public String toString() {
        String estado;
        if(daniado){
            estado= "(Dañado) ";
        }else if(destruido){
            estado= "(Destruido) ";
        }else{
            estado = "(OK) ";
        }
        
        return referencia + ": " + estado + "Consumo: " + consumoDeEnergia;
    }
    
    
}
