package modelo;

public class Chilindrina extends Personaje
{
    public Chilindrina(){
        super("La Chilindrina", 8, "Traviesa y lista", "Hija de Don Ramón");
        agregarDialogo("Fíjate, fíjate, fíjate");
        agregarDialogo("¡Ay, qué bonito!");
    }

    public String accionCon(Personaje otro){
        if(otro instanceof DonRamon){
            return "le pide dinero para dulces a su papá " + otro.getNombre();
        }
        return "le hace una travesura a " + otro.getNombre();
    }
}//End class
