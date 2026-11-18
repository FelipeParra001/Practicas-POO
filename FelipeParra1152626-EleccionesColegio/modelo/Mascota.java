package modelo;

public abstract class Mascota
{
    private String identificacion;
    private String nombre;
    private String genero;
    private int edad;
    private String cualidades;

    public Mascota(String identificacion, String nombre, String genero, int edad, String cualidades){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.cualidades = cualidades;
    }

    // Cada tipo de mascota dice que tipo de animal es
    public abstract String getTipo();

    public String toString(){
        return nombre + " (" + getTipo() + ", " + genero + ", " + edad + " años) - " + cualidades;
    }

    // ==================== GET Y SET ====================

    public String getIdentificacion(){
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getCualidades(){
        return this.cualidades;
    }

    public void setCualidades(String cualidades){
        this.cualidades = cualidades;
    }
}//End class
