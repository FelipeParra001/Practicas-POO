package modelo;

import java.util.ArrayList;

public class GestorPedidos
{
    // Atributos
    private ArrayList<Pedido> pedidos;
    private Pedido pedidoActual;
    private int siguienteNumero;

    // Constructor
    public GestorPedidos()
    {
        pedidos = new ArrayList<Pedido>();
        siguienteNumero = 1;
        pedidoActual = new Pedido(siguienteNumero);
        pedidos.add(pedidoActual);
    }

    public Pedido getPedidoActual()
    {
        return pedidoActual;
    }

    public int getCantidadPedidos()
    {
        return pedidos.size();
    }

    public void guardarCliente(String cedula, String nombre)
    {
        pedidoActual.setCliente(new Cliente(cedula, nombre));
    }

    public void agregarProducto(String codigo, String nombre, double precio)
    {
        pedidoActual.agregarProducto(new Producto(codigo, nombre, precio));
    }

    public void eliminarProducto(int pos)
    {
        pedidoActual.eliminarProducto(pos);
    }

    public void nuevoPedido()
    {
        siguienteNumero = siguienteNumero + 1;
        pedidoActual = new Pedido(siguienteNumero);
        pedidos.add(pedidoActual);
    }
}
