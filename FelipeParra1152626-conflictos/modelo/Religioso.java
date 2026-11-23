package modelo;

/**
 * Conflicto religioso: religiones afectadas.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Religioso extends Conflicto
{
    private String religionsAfectadas;
    
    public Religioso(String nombre, Pais pais, int muertos, int heridos, String religionsAfectadas)
    {
        super(nombre, pais, muertos, heridos);
        this.religionsAfectadas = religionsAfectadas;
    }
    
    public String getTipo()
    {
        return "Religioso";
    }
    
    public String getDetalle()
    {
        return "Religiones afectadas: " + religionsAfectadas;
    }
    
    public String getReligionsAfectadas()
    {
        return religionsAfectadas;
    }
}
