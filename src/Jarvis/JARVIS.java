package Jarvis;

public class JARVIS {
    
    private Armadura armadura;
    private Radar radar;

    public JARVIS(Armadura armadura, Radar radar) {
        this.armadura = armadura;
        this.radar = radar;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public Radar getRadar() {
        return radar;
    }
      

//Mostrando Estado
//Hacer un método que JARVIS muestre el estado de todos los dispositivos y toda la
//información de la Armadura.
    public void mostrarEstado(){
        armadura.escribir(armadura.toString());
    }

//Estado de la Batería
//Hacer un método para que JARVIS informe el estado de la batería en porcentaje a través
//de la consola. Poner como carga máxima del reactor el mayor float posible. Ejecutar
//varias acciones y mostrar el estado de la misma.
    public void estadoDeLaBateria() {
        armadura.escribir("Estado de bateria: " + armadura.estadoDeBateria() + "%");
    }

//Reparando Daños
//Hay veces que se puede reparar los daños de un dispositivo, en general es el 40% de las
//veces que se puede hacer. Utilizar la clase Random para modelar este comportamiento.
//En caso de estar dentro de la probabilidad (es decir probabilidad menor o igual al 40%)
//marcar el dispositivo como sano. Si no dejarlo dañado.
    public void reparandoDanios(Dispositivo d) {
        
        int reparacion = (int) (Math.floor(Math.random() * 10));
        if (reparacion <= 40) {
            d.setDaniado(false);
            armadura.escribir("Se pudo reparar " + d.getReferencia());
        } else {
            armadura.escribir("Se intento reparar " + d.getReferencia() + " sin exito");
        }
    }

//Revisando Dispositivos
//Los dispositivos son revisados por JARVIS para ver si se encuentran dañados. En caso
//de encontrar un dispositivo dañado se debe intentar arreglarlo de manera insistente. Para
//esos intentos hay un 30% de posibilidades de que el dispositivo quede destruido, pero
//se deberá intentar arreglarlo hasta que lo repare, o bien hasta que quede destruido.
//Hacer un método llamado revisar dispositivos que efectúe lo anteriormente descrito, el
//mecanismo insistente debe efectuarlo con un bucle do while.
    public void revisandoDanios() {
        for (Dispositivo dispositivo : armadura.getDispositivos()) {
            do {
                if (dispositivo.isDestruido()) {
                    armadura.escribir("El dispositivo" + dispositivo.getReferencia() + "Está destruido y no se puede reparar");
                } else {
                    int reparacion = (int) (Math.floor(Math.random() * 10));
                    if (reparacion <= 3) {
                        dispositivo.setDaniado(false);
                        dispositivo.setDestruido(true);
                        armadura.escribir("El dispositivo" + dispositivo.getReferencia() + "Está destruido y no se puede reparar");
                    } else {
                        reparandoDanios(dispositivo);
                    }
                }
            } while (!dispositivo.isDaniado());
            
        }
    }
    
    
    
    
}
