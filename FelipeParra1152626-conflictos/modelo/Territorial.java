package modelo;

/**
 * Conflicto territorial: regiones afectadas.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Territorial extends Conflicto
{
    private String regionsAfectadas;
    
    public Territorial(String nombre, Pais pais, int muertos, int heridos, String regionsAfectadas)
    {
        super(nombre, pais, muertos, heridos);
        this.regionsAfectadas = regionsAfectadas;
    }
    
    public String getTipo()
    {
        return "Territorial";
    }
    
    public String getDetalle()
    {
        return "Regiones afectadas: " + regionsAfectadas;
    }
    
    public String getRegionsAfectadas()
    {
        return regionsAfectadas;
    }
}
