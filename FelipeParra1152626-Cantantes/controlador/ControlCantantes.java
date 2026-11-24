package controlador;

import modelo.*;
import vista.JFCantantes;
import javax.swing.*;
import java.awt.event.*;

public class ControlCantantes implements ActionListener
{
    // Atributos
    private GestorCantantes modelo;
    private JFCantantes vista;

    // Constructor
    public ControlCantantes(JFCantantes vista, GestorCantantes modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
        vista.getBtnRegistrar().addActionListener(this);
        vista.getBtnBuscar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnListar().addActionListener(this);
        mostrar();
    }

    // Metodos
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.getBtnRegistrar())
        {
            registrar();
        }
        else if (e.getSource() == vista.getBtnBuscar())
        {
            buscar();
        }
        else if (e.getSource() == vista.getBtnEliminar())
        {
            eliminar();
        }
        else if (e.getSource() == vista.getBtnListar())
        {
            mostrar();
        }
    }

    private void registrar()
    {
        String nombre = vista.getTxtNombre().getText().trim();
        String album = vista.getTxtAlbum().getText().trim();
        String num = vista.getTxtCanciones().getText().trim();
        if (nombre.equals("") || album.equals("") || num.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Complete los datos");
            return;
        }
        int canciones = 0;
        try
        {
            canciones = Integer.parseInt(num);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(vista, "El numero de canciones debe ser entero");
            return;
        }
        if (canciones < 0)
        {
            JOptionPane.showMessageDialog(vista, "El numero de canciones no puede ser negativo");
            return;
        }
        if (!modelo.agregar(new Cantante(nombre, album, canciones)))
        {
            JOptionPane.showMessageDialog(vista, "Ya existe un cantante con ese nombre");
            return;
        }
        vista.limpiar();
        mostrar();
    }

    private void buscar()
    {
        String nombre = vista.getTxtBuscar().getText().trim();
        if (nombre.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Escriba el nombre");
            return;
        }
        Cantante c = modelo.buscarPorNombre(nombre);
        if (c == null)
        {
            JOptionPane.showMessageDialog(vista, "No se encontro");
        }
        else
        {
            vista.getTxtArea().setText(c.toString());
        }
    }

    private void eliminar()
    {
        String nombre = vista.getTxtBuscar().getText().trim();
        if (nombre.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Escriba el nombre a eliminar");
            return;
        }
        if (modelo.eliminar(nombre))
        {
            JOptionPane.showMessageDialog(vista, "Eliminado");
            mostrar();
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "No se encontro");
        }
    }

    private void mostrar()
    {
        vista.getTxtArea().setText(modelo.listar());
    }
}
