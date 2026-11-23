package modelo;

/**
 * Suministro de armas de un traficante a un grupo armado.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Suministra
{
    private Traficante traficante;
    private TipoArma arma;
    private int numeroArmas;
    private GrupoArmado grupo;
    
    public Suministra(Traficante traficante, TipoArma arma, int numeroArmas, GrupoArmado grupo)
    {
        this.traficante = traficante;
        this.arma = arma;
        this.numeroArmas = numeroArmas;
        this.grupo = grupo;
    }
    
    // Realiza el suministro: descuenta las armas del stock si alcanzan
    public boolean realizar()
    {
        return arma.retirarArmas(numeroArmas);
    }
    
    public Traficante getTraficante()
    {
        return traficante;
    }
    
    public TipoArma getArma()
    {
        return arma;
    }
    
    public int getNumeroArmas()
    {
        return numeroArmas;
    }
    
    public GrupoArmado getGrupo()
    {
        return grupo;
    }
}
