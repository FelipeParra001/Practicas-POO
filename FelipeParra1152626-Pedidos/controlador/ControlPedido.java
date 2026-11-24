package controlador;

import modelo.GestorPedidos;
import modelo.Pedido;
import modelo.Producto;
import vista.FrmPedido;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPedido implements ActionListener
{
    // Atributos
    private FrmPedido vista;
    private GestorPedidos modelo;

    // Constructor
    public ControlPedido(FrmPedido vista, GestorPedidos modelo)
    {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnAgregarProducto().addActionListener(this);
        this.vista.getBtnEliminarProducto().addActionListener(this);
        this.vista.getBtnNuevoPedido().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        this.vista.getBtnSalir().addActionListener(this);
        mostrar();
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();
        if (boton == vista.getBtnAgregarProducto())
        {
            agregar();
        }
        else if (boton == vista.getBtnEliminarProducto())
        {
            eliminar();
        }
        else if (boton == vista.getBtnNuevoPedido())
        {
            nuevoPedido();
        }
        else if (boton == vista.getBtnLimpiar())
        {
            vista.limpiarProducto();
        }
        else if (boton == vista.getBtnSalir())
        {
            System.exit(0);
        }
    }

    private void guardarCliente()
    {
        String cedula = vista.getTxtCedula().getText().trim();
        String nombre = vista.getTxtNombreCliente().getText().trim();
        modelo.guardarCliente(cedula, nombre);
    }

    private void agregar()
    {
        String codigo = vista.getTxtCodigoProducto().getText().trim();
        String nombre = vista.getTxtNombreProducto().getText().trim();
        String textoPrecio = vista.getTxtPrecio().getText().trim();
        if (codigo.equals("") || nombre.equals("") || textoPrecio.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Complete codigo, nombre y precio");
            return;
        }
        double precio = 0;
        try
        {
            precio = Double.parseDouble(textoPrecio);
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(vista, "El precio debe ser un numero");
            return;
        }
        // Tambien descarta NaN e Infinity
        if (Double.isNaN(precio) || Double.isInfinite(precio) || precio <= 0)
        {
            JOptionPane.showMessageDialog(vista, "El precio debe ser un numero mayor que cero");
            return;
        }
        guardarCliente();
        modelo.agregarProducto(codigo, nombre, precio);
        vista.limpiarProducto();
        mostrar();
    }

    private void eliminar()
    {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila < 0)
        {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto");
            return;
        }
        modelo.eliminarProducto(fila);
        mostrar();
    }

    private void nuevoPedido()
    {
        String cedula = vista.getTxtCedula().getText().trim();
        String nombre = vista.getTxtNombreCliente().getText().trim();
        if (cedula.equals("") || nombre.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Ingrese la cedula y el nombre del cliente");
            return;
        }
        if (modelo.getPedidoActual().getCantidad() == 0)
        {
            JOptionPane.showMessageDialog(vista, "El pedido no tiene productos");
            return;
        }
        guardarCliente();
        modelo.nuevoPedido();
        vista.limpiarProducto();
        mostrar();
    }

    // Muestra en la ventana los datos del pedido actual
    private void mostrar()
    {
        Pedido pedidoActual = modelo.getPedidoActual();
        vista.getTxtNumeroPedido().setText(String.valueOf(pedidoActual.getNumero()));
        if (pedidoActual.getCliente() != null)
        {
            vista.getTxtCedula().setText(pedidoActual.getCliente().getCedula());
            vista.getTxtNombreCliente().setText(pedidoActual.getCliente().getNombre());
        }
        else
        {
            vista.getTxtCedula().setText("");
            vista.getTxtNombreCliente().setText("");
        }
        vista.getModeloTabla().setRowCount(0);
        for (int i = 0; i < pedidoActual.getCantidad(); i++)
        {
            Producto p = pedidoActual.getProducto(i);
            vista.getModeloTabla().addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getPrecio()});
        }
        vista.getLblTotal().setText("$ " + pedidoActual.getTotal());
    }
}
