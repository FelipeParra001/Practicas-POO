package modelo;

// Personaje nuevo que registra el usuario
public class Vecino extends Personaje
{
    public Vecino(String nombre, int edad, String personalidad, String rol){
        super(nombre, edad, personalidad, rol);
        agregarDialogo("Buenos días, vecino");
    }

    public String accionCon(Personaje otro){
        return "conversa en el patio con " + otro.getNombre();
    }
}//End class
