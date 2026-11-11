package modelo;

public class Fecha
{
    // Atributos
    private int dia;
    private int mes;
    private int anio;

    // Constructor
    public Fecha(int dia, int mes, int anio)
    {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters
    public int getDia()
    {
        return dia;
    }

    public int getMes()
    {
        return mes;
    }

    public int getAnio()
    {
        return anio;
    }

    // Setters
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    // Metodos
    public boolean esValida()
    {
        if (mes < 1 || mes > 12 || dia < 1 || anio < 1)
        {
            return false;
        }
        return dia <= diasDelMes();
    }

    public boolean esAnterior(Fecha otra)
    {
        if (anio != otra.anio)
        {
            return anio < otra.anio;
        }
        if (mes != otra.mes)
        {
            return mes < otra.mes;
        }
        return dia < otra.dia;
    }

    public boolean esPosterior(Fecha otra)
    {
        return otra.esAnterior(this);
    }

    public Fecha sumarDias(int dias)
    {
        int d = dia + dias;
        int m = mes;
        int a = anio;
        while (d > diasDelMes(m, a))
        {
            d = d - diasDelMes(m, a);
            m = m + 1;
            if (m > 12)
            {
                m = 1;
                a = a + 1;
            }
        }
        return new Fecha(d, m, a);
    }

    private int diasDelMes()
    {
        return diasDelMes(mes, anio);
    }

    private int diasDelMes(int m, int a)
    {
        if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            return 30;
        }
        if (m == 2)
        {
            if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0)
            {
                return 29;
            }
            return 28;
        }
        return 31;
    }

    public String toString()
    {
        return dia + "/" + mes + "/" + anio;
    }
}
