package modelo;

import java.util.ArrayList;

public class CalculadorImpuestos
{
    // Atributos
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Rango> rangos;
    private int posicion;

    // Constructor
    public CalculadorImpuestos()
    {
        vehiculos = new ArrayList<Vehiculo>();
        rangos = new ArrayList<Rango>();
        posicion = 0;

        vehiculos.add(new Vehiculo("Ford", "Taurus", 2016, 136340000, "imagen/carro.jpg"));
        vehiculos.add(new Vehiculo("Peugeot", "206", 2016, 10000000, "imagen/peugeot206.png"));
        vehiculos.add(new Vehiculo("Mazda", "Allegro", 2017, 45000000, "imagen/mazda.png"));
        vehiculos.add(new Vehiculo("Peugeot", "307", 2017, 80000000, "imagen/peugeot307.png"));
        vehiculos.add(new Vehiculo("BMW", "X5", 2017, 250000000, "imagen/bmw.png"));

        rangos.add(new Rango(30000000, 1.5));
        rangos.add(new Rango(70000000, 2.0));
        rangos.add(new Rango(200000000, 2.5));
        rangos.add(new Rango(Long.MAX_VALUE, 4.0));
    }

    public Vehiculo getVehiculoActual()
    {
        return vehiculos.get(posicion);
    }

    public void irAlPrimero()
    {
        posicion = 0;
    }

    public void irAlAnterior()
    {
        if (posicion > 0)
        {
            posicion--;
        }
    }

    public void irAlSiguiente()
    {
        if (posicion < vehiculos.size() - 1)
        {
            posicion++;
        }
    }

    public void irAlUltimo()
    {
        posicion = vehiculos.size() - 1;
    }

    public boolean buscarPorLinea(String linea)
    {
        for (int i = 0; i < vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getLinea().equalsIgnoreCase(linea))
            {
                posicion = i;
                return true;
            }
        }
        return false;
    }

    public boolean buscarPorMarca(String marca)
    {
        for (int i = 0; i < vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getMarca().equalsIgnoreCase(marca))
            {
                posicion = i;
                return true;
            }
        }
        return false;
    }

    public void buscarMasCaro()
    {
        int posMayor = 0;
        for (int i = 1; i < vehiculos.size(); i++)
        {
            if (vehiculos.get(i).getPrecio() > vehiculos.get(posMayor).getPrecio())
            {
                posMayor = i;
            }
        }
        posicion = posMayor;
    }

    public double calcularImpuesto()
    {
        long precio = getVehiculoActual().getPrecio();
        for (int i = 0; i < rangos.size(); i++)
        {
            if (precio <= rangos.get(i).getLimite())
            {
                return precio * rangos.get(i).getPorcentaje() / 100;
            }
        }
        return 0;
    }

    public double calcularTotal(boolean prontoPago, boolean servicioPublico, boolean traslado)
    {
        double total = calcularImpuesto();
        if (prontoPago)
        {
            total = total - total * 10 / 100;
        }
        if (servicioPublico)
        {
            total = total - 50000;
            if (total < 0)
            {
                total = 0;
            }
        }
        if (traslado)
        {
            total = total - total * 5 / 100;
        }
        return total;
    }

    public void agregarRango(long limite, double porcentaje)
    {
        rangos.add(new Rango(limite, porcentaje));
    }

    public void modificarRango(int pos, long limite, double porcentaje)
    {
        rangos.get(pos).setLimite(limite);
        rangos.get(pos).setPorcentaje(porcentaje);
    }
}
