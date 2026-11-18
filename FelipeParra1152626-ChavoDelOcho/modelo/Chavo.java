package modelo;

public class Chavo extends Personaje
{
    public Chavo(){
        super("El Chavo", 8, "Inocente y siempre con hambre", "Vive en el barril");
        agregarDialogo("¡Eso, eso, eso!");
        agregarDialogo("Fue sin querer queriendo");
        agregarDialogo("Se me chispoteó");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof DonaFlorinda){
            return "le pide una torta de jamón a " + otro.getNombre();
        }
        else if(otro instanceof Quico){
            return "invita a " + otro.getNombre() + " a jugar con la pelota";
        }
        return "juega en el patio con " + otro.getNombre();
    }
}//End class
