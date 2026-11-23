package modelo;

/**
 * Organizacion que media en los conflictos y el tipo de ayuda que presta.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class OrganizacionMediadora
{   private String codigo;  
    private String nombre;
    private TipoOrganizacion tipo;
    private String dependecia;
    private int numPersonasDesplegadas;
    private TipoAyuda ayuda;
    
    public OrganizacionMediadora(String codigo, String nombre, TipoOrganizacion tipo,
                                 String dependecia, int numPersonasDesplegadas, TipoAyuda ayuda)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.dependecia = dependecia;
        this.numPersonasDesplegadas = numPersonasDesplegadas;
        this.ayuda = ayuda;
    }
    
    public String getCodigo()
    {
        return codigo;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public TipoOrganizacion getTipo()
    {
        return tipo;
    }
    
    public String getDependecia()
    {
        return dependecia;
    }
    
    public int getNumPersonasDesplegadas()
    {
        return numPersonasDesplegadas;
    }
    
    public TipoAyuda getAyuda()
    {
        return ayuda;
    }
}
