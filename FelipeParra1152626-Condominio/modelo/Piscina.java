package modelo;

/**
 * Piscina del condominio.
 */
public class Piscina extends ZonaComun
{
    public Piscina(){
        super(30, 7, 19);
    }

    public String getNombre(){
        return "Piscina";
    }
}//End class
