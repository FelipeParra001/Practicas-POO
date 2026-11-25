package modelo;

/**
 * Clase padre de todas las personas del sistema.
 * Cada tipo de persona tiene un rol y un nivel de acceso diferente.
 */
public abstract class Persona
{
    private String cedula;
    private String nombre;
    private String telefono;

    public Persona(String cedula, String nombre, String telefono){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // ==================== METODOS ABSTRACTOS ====================

    // Nombre del rol de la persona dentro del sistema
    public abstract String getRol();

    // Nivel de acceso: 3 administrador, 2 vigilante, 1 propietario/residente, 0 visitante
    public abstract int getNivelAcceso();

    public String toString(){
        return getRol() + " - " + nombre + " (C.C. " + cedula + ", tel. " + telefono + ", nivel " + getNivelAcceso() + ")";
    }

    // ==================== GET Y SET ====================

    public String getCedula(){
        return this.cedula;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
}//End class
