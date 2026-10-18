package modelo;

public class Cliente
{
    // Atributos
    private String cedula;
    private String nombre;

    // Constructor
    public Cliente(String cedula, String nombre)
    {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula()
    {
        return cedula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
