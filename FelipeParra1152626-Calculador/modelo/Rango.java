package modelo;

public class Rango
{
    // Atributos
    private long limite;
    private double porcentaje;

    // Constructor
    public Rango(long limite, double porcentaje)
    {
        this.limite = limite;
        this.porcentaje = porcentaje;
    }

    public long getLimite()
    {
        return limite;
    }

    public double getPorcentaje()
    {
        return porcentaje;
    }

    public void setLimite(long limite)
    {
        this.limite = limite;
    }

    public void setPorcentaje(double porcentaje)
    {
        this.porcentaje = porcentaje;
    }
}
