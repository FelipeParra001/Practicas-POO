package modelo;

/**
 * Representa una fecha (dia, mes y año).
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class Fecha
{   private int dia;
    private int mes;
    private int year;
    
    public Fecha(){}
    
    public Fecha(int dia, int mes, int year)
    {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String toString()
    {
        return dia + "/" + mes + "/" + year;
    }
}
