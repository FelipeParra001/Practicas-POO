package modelo;

/**
 * Vigilante de un condominio. Es quien registra la entrada de los visitantes.
 */
public class Vigilante extends Persona
{
    private Condominio condominio;
    private String turno;

    public Vigilante(String cedula, String nombre, String telefono, Condominio condominio, String turno){
        super(cedula, nombre, telefono);
        this.condominio = condominio;
        this.turno = turno;
    }

    public String getRol(){
        return "Vigilante";
    }

    public int getNivelAcceso(){
        return 2;
    }

    public String toString(){
        return super.toString() + " - " + condominio.getNombre() + ", turno " + turno;
    }

    // ==================== GET Y SET ====================

    public Condominio getCondominio(){
        return this.condominio;
    }

    public String getTurno(){
        return this.turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }
}//End class
