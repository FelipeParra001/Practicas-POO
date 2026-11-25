package modelo;

/**
 * Administrador de un condominio. Es el usuario con mayor nivel de acceso.
 */
public class Administrador extends Persona
{
    private Condominio condominio;

    public Administrador(String cedula, String nombre, String telefono, Condominio condominio){
        super(cedula, nombre, telefono);
        this.condominio = condominio;
    }

    public String getRol(){
        return "Administrador";
    }

    public int getNivelAcceso(){
        return 3;
    }

    public String toString(){
        return super.toString() + " - Administra " + condominio.getNombre();
    }

    // ==================== GET Y SET ====================

    public Condominio getCondominio(){
        return this.condominio;
    }
}//End class
