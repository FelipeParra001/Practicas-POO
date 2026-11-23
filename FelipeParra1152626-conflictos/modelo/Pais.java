package modelo;

/**
 * Pais donde ocurre un conflicto.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Pais
{
    private String nombre;
    
    public Pais(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
