package modelo;

/**
 * Traficante de armas que suministra a los grupos armados.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Traficante
{ 
    private String nombre;
    
    public Traficante(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
