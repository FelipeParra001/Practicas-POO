package modelo;

public class Estudiante
{
    private String nombre;
    private String apellido;
    private int grado;
    private String grupo;

    public Estudiante(String nombre, String apellido, int grado, String grupo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.grupo = grupo;
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    public String toString(){
        return getNombreCompleto() + " (grado " + grado + "-" + grupo + ")";
    }

    // ==================== GET Y SET ====================

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public int getGrado(){
        return this.grado;
    }

    public void setGrado(int grado){
        this.grado = grado;
    }

    public String getGrupo(){
        return this.grupo;
    }

    public void setGrupo(String grupo){
        this.grupo = grupo;
    }
}//End class
