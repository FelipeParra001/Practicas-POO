package modelo;

public class Alcancia
{
    // Atributos
    private int monedas50;
    private int monedas100;
    private int monedas200;
    private int monedas500;
    private int monedas1000;

    // Constructor
    public Alcancia()
    {
        monedas50 = 0;
        monedas100 = 0;
        monedas200 = 0;
        monedas500 = 0;
        monedas1000 = 0;
    }

    public void agregarMonedas(int valor)
    {
        if (valor == 50)
        {
            monedas50 = monedas50 + 1;
        }
        else if (valor == 100)
        {
            monedas100 = monedas100 + 1;
        }
        else if (valor == 200)
        {
            monedas200 = monedas200 + 1;
        }
        else if (valor == 500)
        {
            monedas500 = monedas500 + 1;
        }
        else if (valor == 1000)
        {
            monedas1000 = monedas1000 + 1;
        }
    }

    public int getSaldo()
    {
        return (monedas50 * 50) + (monedas100 * 100) + (monedas200 * 200) + (monedas500 * 500) + (monedas1000 * 1000);
    }

    public int getTotalMonedas()
    {
        return monedas50 + monedas100 + monedas200 + monedas500 + monedas1000;
    }

    public int getMonedas50()
    {
        return monedas50;
    }

    public int getMonedas100()
    {
        return monedas100;
    }

    public int getMonedas200()
    {
        return monedas200;
    }

    public int getMonedas500()
    {
        return monedas500;
    }

    public int getMonedas1000()
    {
        return monedas1000;
    }

    public void setMonedas50(int monedas50)
    {
        this.monedas50 = monedas50;
    }

    public void setMonedas100(int monedas100)
    {
        this.monedas100 = monedas100;
    }

    public void setMonedas200(int monedas200)
    {
        this.monedas200 = monedas200;
    }

    public void setMonedas500(int monedas500)
    {
        this.monedas500 = monedas500;
    }

    public void setMonedas1000(int monedas1000)
    {
        this.monedas1000 = monedas1000;
    }

    public void vaciar()
    {
        monedas50 = 0;
        monedas100 = 0;
        monedas200 = 0;
        monedas500 = 0;
        monedas1000 = 0;
    }
}
