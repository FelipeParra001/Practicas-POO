package modelo;

/**
 * Cancha o zona deportiva del condominio.
 */
public class ZonaDeportiva extends ZonaComun
{
    public ZonaDeportiva(){
        super(40, 6, 21);
    }

    public String getNombre(){
        return "Zona deportiva";
    }
}//End class
