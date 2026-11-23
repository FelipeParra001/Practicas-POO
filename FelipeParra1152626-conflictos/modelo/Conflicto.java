package modelo;

/**
 * Conflicto belico: nombre, pais, muertos y heridos.
 * Es la superclase de Territorial, Religioso, Economico y Racial.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Conflicto
{
    protected String nombre;
    protected Pais pais;
    protected int muertos;
    protected int heridos;
   
    public Conflicto(String nombre, Pais pais, int muertos, int heridos)
    {
        this.nombre = nombre;
        this.pais = pais;
        this.muertos = muertos;
        this.heridos = heridos;
    }
    
    // Total de personas afectadas (muertos + heridos)
    public int getTotalAfectados()
    {
        return muertos + heridos;
    }
    
    // Cada subclase dice de que tipo es
    public String getTipo()
    {
        return "General";
    }
    
    // Dato propio de cada tipo de conflicto
    public String getDetalle()
    {
        return "";
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public Pais getPais()
    {
        return pais;
    }
    
    public int getMuertos()
    {
        return muertos;
    }
    
    public void setMuertos(int muertos)
    {
        this.muertos = muertos;
    }
    
    public int getHeridos()
    {
        return heridos;
    }
    
    public void setHeridos(int heridos)
    {
        this.heridos = heridos;
    }
    
    public String toString()
    {
        return nombre + " (" + getTipo() + ") - Pais: " + pais.getNombre()
            + " - Muertos: " + muertos + " - Heridos: " + heridos
            + " - " + getDetalle();
    }
}
