package controlador;

import modelo.GestorConflictos;
import vista.JFConflictos;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador de la ventana de conflictos belicos.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class ControlConflictos implements ActionListener
{
    // Atributos
    private JFConflictos vista;
    private GestorConflictos modelo;

    // Constructor
    public ControlConflictos(JFConflictos vista, GestorConflictos modelo)
    {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnRegistrarConflicto().addActionListener(this);
        this.vista.getBtnRegistrarGrupo().addActionListener(this);
        this.vista.getBtnAgregarDivision().addActionListener(this);
        this.vista.getBtnReporte().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        this.vista.getBtnSalir().addActionListener(this);
        mostrarReporte();
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();
        if (boton == vista.getBtnRegistrarConflicto())
        {
            registrarConflicto();
        }
        else if (boton == vista.getBtnRegistrarGrupo())
        {
            registrarGrupo();
        }
        else if (boton == vista.getBtnAgregarDivision())
        {
            agregarDivision();
        }
        else if (boton == vista.getBtnReporte())
        {
            mostrarReporte();
        }
        else if (boton == vista.getBtnLimpiar())
        {
            vista.limpiar();
        }
        else if (boton == vista.getBtnSalir())
        {
            System.exit(0);
        }
    }

    private void registrarConflicto()
    {
        String nombre = vista.getTxtNombreConflicto().getText().trim();
        String pais = vista.getTxtPais().getText().trim();
        String tipo = (String) vista.getCbTipoConflicto().getSelectedItem();
        String detalle = vista.getTxtDetalle().getText().trim();
        if (nombre.equals("") || pais.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Complete nombre y pais del conflicto");
            return;
        }
        int muertos = 0;
        int heridos = 0;
        try
        {
            muertos = Integer.parseInt(vista.getTxtMuertos().getText().trim());
            heridos = Integer.parseInt(vista.getTxtHeridos().getText().trim());
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(vista, "Muertos y heridos deben ser numeros enteros");
            return;
        }
        if (muertos < 0 || heridos < 0)
        {
            JOptionPane.showMessageDialog(vista, "Muertos y heridos no pueden ser negativos");
            return;
        }
        if (modelo.registrarConflicto(tipo, nombre, pais, muertos, heridos, detalle))
        {
            JOptionPane.showMessageDialog(vista, "Conflicto registrado");
            mostrarReporte();
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "Ya existe un conflicto con ese nombre");
        }
    }

    private void registrarGrupo()
    {
        String codigo = vista.getTxtCodigoGrupo().getText().trim();
        String nombre = vista.getTxtNombreGrupo().getText().trim();
        String lider = vista.getTxtLider().getText().trim();
        String apoyos = vista.getTxtApoyos().getText().trim();
        if (codigo.equals("") || nombre.equals("") || lider.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Complete codigo, nombre y lider del grupo");
            return;
        }
        if (modelo.registrarGrupo(codigo, nombre, lider, apoyos))
        {
            JOptionPane.showMessageDialog(vista, "Grupo armado registrado");
            mostrarReporte();
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "Ya existe un grupo con ese codigo");
        }
    }

    private void agregarDivision()
    {
        String codigoGrupo = vista.getTxtGrupoDivision().getText().trim();
        if (codigoGrupo.equals(""))
        {
            JOptionPane.showMessageDialog(vista, "Escriba el codigo del grupo");
            return;
        }
        int consecutivo = 0;
        int barcos = 0;
        int aviones = 0;
        int hombres = 0;
        int tanques = 0;
        int bajas = 0;
        try
        {
            consecutivo = Integer.parseInt(vista.getTxtConsecutivo().getText().trim());
            barcos = Integer.parseInt(vista.getTxtBarcos().getText().trim());
            aviones = Integer.parseInt(vista.getTxtAviones().getText().trim());
            hombres = Integer.parseInt(vista.getTxtHombres().getText().trim());
            tanques = Integer.parseInt(vista.getTxtTanques().getText().trim());
            bajas = Integer.parseInt(vista.getTxtBajas().getText().trim());
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(vista, "Los datos de la division deben ser numeros enteros");
            return;
        }
        if (consecutivo < 0 || barcos < 0 || aviones < 0 || hombres < 0 || tanques < 0 || bajas < 0)
        {
            JOptionPane.showMessageDialog(vista, "Los datos de la division no pueden ser negativos");
            return;
        }
        int resultado = modelo.agregarDivision(codigoGrupo, consecutivo, barcos, aviones, hombres, tanques, bajas);
        if (resultado == 0)
        {
            JOptionPane.showMessageDialog(vista, "Division agregada");
            mostrarReporte();
        }
        else if (resultado == 1)
        {
            JOptionPane.showMessageDialog(vista, "No existe un grupo con ese codigo");
        }
        else
        {
            JOptionPane.showMessageDialog(vista, "Ese grupo ya tiene una division con ese consecutivo");
        }
    }

    // Muestra en la ventana el reporte del modelo
    private void mostrarReporte()
    {
        vista.getTxtReporte().setText(modelo.reporte());
    }
}
