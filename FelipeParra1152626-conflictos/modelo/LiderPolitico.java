package modelo;

/**
 * Lider politico de un grupo armado y los apoyos que tiene.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class LiderPolitico
{
    private String nombre;
    private GrupoArmado grupo;
    private String apoyos;
    
    public LiderPolitico(String nombre, String apoyos)
    {
        this.nombre = nombre;
        this.apoyos = apoyos;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public GrupoArmado getGrupo()
    {
        return grupo;
    }
    
    public void setGrupo(GrupoArmado grupo)
    {
        this.grupo = grupo;
    }
    
    public String getApoyos()
    {
        return apoyos;
    }
}
