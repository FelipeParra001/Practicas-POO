package modelo;

/**
 * Jefe militar: dirige una division y obedece a un lider politico.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class JefeMilitar
{ 
    private Division division;
    private String codigo;
    private String rango;
    private LiderPolitico liderObedece;
    
    public JefeMilitar(String codigo, String rango, Division division, LiderPolitico liderObedece)
    {
        this.codigo = codigo;
        this.rango = rango;
        this.division = division;
        this.liderObedece = liderObedece;
    }
    
    public Division getDivision()
    {
        return division;
    }
    
    public String getCodigo()
    {
        return codigo;
    }
    
    public String getRango()
    {
        return rango;
    }
    
    public LiderPolitico getLiderObedece()
    {
        return liderObedece;
    }
}
