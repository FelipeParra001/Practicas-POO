package Modelo;

public class Cardenal
{
    // Atributos
    private String pais;
    private String cedula;
    private String nombre;
    private int edad;
    private TipoCardenal tipo;

    // Constructor
    public Cardenal(String pais, String cedula, String nombre, int edad, TipoCardenal tipo)
    {
        this.pais = pais;
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    // Getters
    public String getPais()
    {
        return pais;
    }

    public String getCedula()
    {
        return cedula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public TipoCardenal getTipo()
    {
        return tipo;
    }

    // Setters
    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public void setCedula(String cedula)
    {
        this.cedula = cedula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public void setTipo(TipoCardenal tipo)
    {
        this.tipo = tipo;
    }

    // Metodos
    public boolean esElector()
    {
        return edad < 80;
    }

    public String toString()
    {
        return nombre + " - " + pais + " (" + edad + ")";
    }
}
