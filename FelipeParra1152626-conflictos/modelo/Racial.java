package modelo;

/**
 * Conflicto racial: etnias enfrentadas.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Racial extends Conflicto
{
    private String etniasEnfrentadas;
    
    public Racial(String nombre, Pais pais, int muertos, int heridos, String etniasEnfrentadas)
    {
        super(nombre, pais, muertos, heridos);
        this.etniasEnfrentadas = etniasEnfrentadas;
    }
    
    public String getTipo()
    {
        return "Racial";
    }
    
    public String getDetalle()
    {
        return "Etnias enfrentadas: " + etniasEnfrentadas;
    }
    
    public String getEtniasEnfrentadas()
    {
        return etniasEnfrentadas;
    }
}
