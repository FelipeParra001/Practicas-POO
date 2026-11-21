package controlador;

import modelo.CalculadorImpuestos;
import modelo.Vehiculo;
import vista.JFImpuestos;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlCalculador implements ActionListener
{
    // ---------- ATRIBUTOS ----------
    private JFImpuestos vista;
    private CalculadorImpuestos modelo;

    // ---------- CONSTRUCTOR ----------
    public ControlCalculador(JFImpuestos vista, CalculadorImpuestos modelo)
    {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBotonPrimero().addActionListener(this);
        this.vista.getBotonAnterior().addActionListener(this);
        this.vista.getBotonSiguiente().addActionListener(this);
        this.vista.getBotonUltimo().addActionListener(this);
        this.vista.getBotonBuscarLinea().addActionListener(this);
        this.vista.getBotonBuscarMarca().addActionListener(this);
        this.vista.getBotonBuscarCaro().addActionListener(this);
        this.vista.getBotonCalcular().addActionListener(this);
        this.vista.getBotonOpcion1().addActionListener(this);
        this.vista.getBotonOpcion2().addActionListener(this);

        mostrarVehiculo();
    }

    // ---------- LOGICA DE LOS BOTONES ----------
    // Muestra en pantalla el vehiculo actual
    private void mostrarVehiculo()
    {
        Vehiculo v = modelo.getVehiculoActual();
        vista.mostrarVehiculo(v.getMarca(),
                              v.getLinea(),
                              "" + v.getModelo(),
                              "$ " + String.format("%,d", v.getPrecio()),
                              v.getImagen());
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();

        if (boton == vista.getBotonPrimero())
        {
            modelo.irAlPrimero();
            mostrarVehiculo();
        }
        else if (boton == vista.getBotonAnterior())
        {
            modelo.irAlAnterior();
            mostrarVehiculo();
        }
        else if (boton == vista.getBotonSiguiente())
        {
            modelo.irAlSiguiente();
            mostrarVehiculo();
        }
        else if (boton == vista.getBotonUltimo())
        {
            modelo.irAlUltimo();
            mostrarVehiculo();
        }
        else if (boton == vista.getBotonBuscarLinea())
        {
            buscarPorLinea();
        }
        else if (boton == vista.getBotonBuscarMarca())
        {
            buscarPorMarca();
        }
        else if (boton == vista.getBotonBuscarCaro())
        {
            modelo.buscarMasCaro();
            mostrarVehiculo();
        }
        else if (boton == vista.getBotonCalcular())
        {
            calcular();
        }
        // Opcion 1 y Opcion 2 todavia no hacen nada
    }

    private void buscarPorLinea()
    {
        String linea = vista.getBusquedaLinea().getText().trim();
        if (linea.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Escriba la linea que desea buscar");
        }
        else if (modelo.buscarPorLinea(linea))
        {
            mostrarVehiculo();
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "No se encontro un vehiculo con esa linea");
        }
    }

    private void buscarPorMarca()
    {
        String marca = vista.getBusquedaMarca().getText().trim();
        if (marca.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Escriba la marca que desea buscar");
        }
        else if (modelo.buscarPorMarca(marca))
        {
            mostrarVehiculo();
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "No se encontro un vehiculo con esa marca");
        }
    }

    private void calcular()
    {
        double total = modelo.calcularTotal(vista.getCheckProntoPago().isSelected(),
                                            vista.getCheckServicioPublico().isSelected(),
                                            vista.getCheckTraslado().isSelected());
        JOptionPane.showMessageDialog(vista, "El valor total a pagar es: $ " + String.format("%,.0f", total));
    }
}
