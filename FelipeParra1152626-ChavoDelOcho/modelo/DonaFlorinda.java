package modelo;

public class DonaFlorinda extends Personaje
{
    public DonaFlorinda(){
        super("Doña Florinda", 40, "Orgullosa y elegante", "Mamá de Quico");
        agregarDialogo("Vámonos, tesoro, no te juntes con esta chusma");
        agregarDialogo("¡Chusma, chusma!");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof DonRamon){
            return "le da una cachetada a " + otro.getNombre();
        }
        else if(otro instanceof Chavo){
            return "le regala una torta de jamón a " + otro.getNombre();
        }
        return "invita a " + otro.getNombre() + " a tomar una tacita de café";
    }
}//End class
