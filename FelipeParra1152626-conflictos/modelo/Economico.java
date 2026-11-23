package modelo;

/**
 * Conflicto economico: se pelea por materias primas.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Economico extends Conflicto
{
    private String materiasPrimas;
    
    public Economico(String nombre, Pais pais, int muertos, int heridos, String materiasPrimas)
    {
        super(nombre, pais, muertos, heridos);
        this.materiasPrimas = materiasPrimas;
    }
    
    public String getTipo()
    {
        return "Economico";
    }
    
    public String getDetalle()
    {
        return "Materias primas: " + materiasPrimas;
    }
    
    public String getMateriasPrimas()
    {
        return materiasPrimas;
    }
}
