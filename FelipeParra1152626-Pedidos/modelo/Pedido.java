package modelo;

import java.util.ArrayList;

public class Pedido
{
    // Atributos
    private int numero;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    // Constructor
    public Pedido(int numero)
    {
        this.numero = numero;
        productos = new ArrayList<Producto>();
    }

    public int getNumero()
    {
        return numero;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto)
    {
        productos.add(producto);
    }

    public void eliminarProducto(int pos)
    {
        if (pos >= 0 && pos < productos.size())
        {
            productos.remove(pos);
        }
    }

    public Producto getProducto(int pos)
    {
        return productos.get(pos);
    }

    public int getCantidad()
    {
        return productos.size();
    }

    public double getTotal()
    {
        double total = 0;
        for (int i = 0; i < productos.size(); i++)
        {
            total = total + productos.get(i).getPrecio();
        }
        return total;
    }
}
