package modelo;

public class DonRamon extends Personaje
{
    public DonRamon(){
        super("Don Ramón", 45, "Flojo pero buena gente", "Inquilino que debe la renta");
        agregarDialogo("¿Qué pasó, qué pasó? ¡Vamos!");
        agregarDialogo("No te doy otra nomás porque...");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof SenorBarriga){
            return "se esconde de " + otro.getNombre() + " para no pagar la renta";
        }
        else if(otro instanceof DonaFlorinda){
            return "trata de explicarle un malentendido a " + otro.getNombre();
        }
        return "le pide un favor a " + otro.getNombre();
    }
}//End class
