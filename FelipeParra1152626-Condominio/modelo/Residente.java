package modelo;

/**
 * Persona que vive en una unidad del condominio.
 */
public class Residente extends Persona
{
    private Unidad unidad;

    public Residente(String cedula, String nombre, String telefono, Unidad unidad){
        super(cedula, nombre, telefono);
        this.unidad = unidad;
    }

    public String getRol(){
        return "Residente";
    }

    public int getNivelAcceso(){
        return 1;
    }

    public String toString(){
        return super.toString() + " - Vive en " + unidad.getCodigo() + " [" + unidad.getCondominio().getNombre() + "]";
    }

    // ==================== GET Y SET ====================

    public Unidad getUnidad(){
        return this.unidad;
    }
}//End class
