package modelo;

public class Quico extends Personaje
{
    public Quico(){
        super("Quico", 9, "Presumido y llorón", "Hijo de Doña Florinda");
        agregarDialogo("¡Cállate, cállate, que me desesperas!");
        agregarDialogo("¡Chusma, chusma!");
        agregarDialogo("No me simpatizas");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof Chavo){
            return "le presume su pelota nueva a " + otro.getNombre();
        }
        return "le muestra sus juguetes a " + otro.getNombre();
    }
}//End class
