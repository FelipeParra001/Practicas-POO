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
    public ControlCantantes(JFCantantes vista)
    {
        this.vista = vista;
        modelo = new GestorCantantes();
        vista.getBtnRegistrar().addActionListener(this);
        vista.getBtnBuscar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnListar().addActionListener(this);
        mostrar();
    }

    // Metodos
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.getBtnRegistrar()) registrar();
        if (e.getSource() == vista.getBtnBuscar()) buscar();
        if (e.getSource() == vista.getBtnEliminar()) eliminar();
        if (e.getSource() == vista.getBtnListar()) mostrar();
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
        modelo.agregar(new Cantante(nombre, album, canciones));
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
