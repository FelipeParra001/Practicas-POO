package Controlador;

import Modelo.*;
import Vista.JFGestorCardenales;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlConclave implements ActionListener
{
    // Atributos
    private JFGestorCardenales vista;
    private GestorCardenales gestor;

    // Constructor
    public ControlConclave(JFGestorCardenales vista, GestorCardenales gestor)
    {
        this.vista = vista;
        this.gestor = gestor;

        this.vista.getBtnVotar().addActionListener(this);
        this.vista.getBtnMostrarResultados().addActionListener(this);
        this.vista.getBtnSiguienteRonda().addActionListener(this);
        cargarCombo();
        mostrar();
    }

    // Metodos
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vista.getBtnVotar())
        {
            votar();
        }
        else if (e.getSource() == vista.getBtnMostrarResultados())
        {
            mostrar();
        }
        else if (e.getSource() == vista.getBtnSiguienteRonda())
        {
            siguiente();
        }
    }

    // Llena el combo con la lista de cardenales
    private void cargarCombo()
    {
        ArrayList<Cardenal> lista = gestor.getCardenales();
        for (int i = 0; i < lista.size(); i++)
        {
            vista.getCmbCardenales().addItem(lista.get(i).toString());
        }
    }

    private void votar()
    {
        int indice = vista.getCmbCardenales().getSelectedIndex();
        if (indice < 0)
        {
            return;
        }
        Cardenal elegido = gestor.getCardenales().get(indice);
        boolean ok = gestor.votar(elegido);
        if (!ok)
        {
            JOptionPane.showMessageDialog(vista, "No se puede votar");
        }
        mostrar();
        if (gestor.rondaCerrada())
        {
            vista.getBtnVotar().setEnabled(false);
        }
        if (gestor.getPapa() != null)
        {
            vista.getBtnSiguienteRonda().setEnabled(false);
            vista.getBtnVotar().setEnabled(false);
        }
    }

    private void siguiente()
    {
        if (gestor.getPapa() != null)
        {
            vista.getBtnSiguienteRonda().setEnabled(false);
            return;
        }
        boolean ok = gestor.siguienteRonda();
        if (!ok)
        {
            JOptionPane.showMessageDialog(vista, "Cierre la ronda antes de continuar");
            return;
        }
        vista.getBtnVotar().setEnabled(true);
        vista.getTxtNumRonda().setText("" + gestor.getRondaActual().getNumero());
        mostrar();
    }

    // Muestra los electores y los resultados de la ronda
    private void mostrar()
    {
        String texto = "ELECTORES\n" + gestor.listarElectores() + "\n" + gestor.resultadosRonda();
        vista.getAreaResultado().setText(texto);
        vista.getTxtNumRonda().setText("" + gestor.getRondaActual().getNumero());
    }
}
