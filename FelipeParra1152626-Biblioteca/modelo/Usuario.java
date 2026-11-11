package modelo;

public abstract class Usuario
{
    // Atributos
    private String codigo;
    private String nombre;

    // Constructor
    public Usuario(String codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters
    public String getCodigo()
    {
        return codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    // Setters
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    // Metodos
    public abstract int plazoDias();

    public abstract String getTipo();

    public String toString()
    {
        return codigo + " - " + nombre + " (" + getTipo() + ")";
    }
}
